package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.LottosDto;
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
                Arguments.arguments(Error.LOTTO_NUMBER_OUT_OF_BOUND.getMessage()));
    }

    @DisplayName("로또 생성 결과 출력 테스트")
    @Test
    public void 로또_생성_결과_출력_테스트() {
        //given
        Lotto firstLotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto secondLotto = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        List<Lotto> lottos = List.of(firstLotto, secondLotto);
        LottosDto lottosDto = LottosDto.create(lottos);

        // When
        OutputView.printLottos(lottosDto);

        // Then
        String expectedOutput = String.join(System.lineSeparator(),
                "",
                "2개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "");
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

}
