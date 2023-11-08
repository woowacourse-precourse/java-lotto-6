package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;
import lotto.model.Lotto;
import lotto.view.message.Error;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(systemOut);
    }

    @DisplayName("에러 Message를 출력하는 부분 테스트")
    @ParameterizedTest
    @MethodSource("errorMessageProvider")
    public void 에러_메세지_출력_테스트(String message) {
        //when
        OutputView.printMessage(message);

        //then
        assertThat(outContent.toString()).startsWith("[ERROR]");
    }

    static Stream<Arguments> errorMessageProvider() {
        return Stream.of(
                Arguments.arguments(Error.PURCHASE_AMOUNT_VALIDATION.getMessage()),
                Arguments.arguments(Error.LOTTO_NUMBER_OVERSIZE.getMessage()),
                Arguments.arguments(Error.LOTTO_NUMBER_DUPLICATE.getMessage()),
                Arguments.arguments(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage()));
    }

    @DisplayName("로또 생성 결과 출력 테스트")
    @Test
    public void 로또_생성_결과_출력_테스트() {
        //given
        Lotto firstLotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto secondLotto = new Lotto(List.of(5, 38, 3, 11, 16, 32));
        List<Lotto> lottos = List.of(firstLotto, secondLotto);
        LottosDto lottosDto = LottosDto.create(lottos);

        // When
        OutputView.printLottos(lottosDto);

        // Then
        String expectedOutput = String.join(
                "\n",
                "",
                "2개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                ""
        );
        assertThat(outContent.toString()).isEqualToIgnoringWhitespace(expectedOutput);
    }

    @DisplayName("당첨내역과 수익률을 출력한다")
    @Test
    public void 당첨내역과_수익률을_출력() {
        // given
        ResultDto resultDto = ResultDto.create(Arrays.asList(1, 0, 0, 2, 0), 1002.5);

        //when
        OutputView.printResult(resultDto);

        //then
        String expectedOutput = String.join(
                "\n",
                "",
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 2개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 1002.5%입니다."
        );
        assertThat(outContent.toString()).isEqualToIgnoringWhitespace(expectedOutput);
    }
}
