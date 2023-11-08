package lotto.view.outputview;

import lotto.domain.BuyLotto;
import lotto.domain.Lotto;
import lotto.dto.BuyLottoDto;
import lotto.dto.OutputDto;
import lotto.view.ParameterConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyOutputViewTest {
    private final LottoBuyOutputView outputView = new LottoBuyOutputView();
    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("BUY_LOOTO_DTO의 매핑된 값이 null 일 때 '구입 금액을 력해주세요.'가 나온다.")
    void 구입_금액_출력_테스트() {
        //given
        Map<String, OutputDto> model = new HashMap<>();
        model.put(ParameterConfig.BUY_PRICE, null);
        //when
        outputView.view(model);
        //then
        assertThat(outputMessage.toString())
                .hasToString("구입금액을 입력해 주세요.\n");
    }

    @ParameterizedTest
    @MethodSource("setBuyParam")
    @DisplayName("구입한 로또가 정상적으로 오름차순으로 나와야한다.")
    void 구입_로또_출력_테스트(BuyLotto buyLotto) {
        Map<String, OutputDto> model = new HashMap<>();
        BuyLottoDto.Output dto = new BuyLottoDto.Output(buyLotto);
        model.put(ParameterConfig.BUY_PRICE, dto);
        //when
        outputView.view(model);
        //then
        String result = getExpectedResult(buyLotto);
        assertThat(outputMessage.toString()).contains(result);
    }

    private String getExpectedResult(BuyLotto buyLotto) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : buyLotto.lotto()) {
            List<Integer> list = lotto.getNumbers()
                    .stream().sorted(Comparator.naturalOrder())
                    .toList();

            sb.append(list.toString() + "\n");
        }
        return sb.toString();
    }

    static Stream<Arguments> setBuyParam() {
        return Stream.of(
                Arguments.of(new BuyLotto(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(10, 3, 4, 27, 21, 1)),
                        new Lotto(List.of(4, 3, 1, 27, 7, 10)),
                        new Lotto(List.of(4, 3, 42, 27, 1, 9)),
                        new Lotto(List.of(10, 2, 13, 1, 5, 17)),
                        new Lotto(List.of(1, 20, 31, 42, 5, 6)),
                        new Lotto(List.of(10, 20, 31, 42, 12, 6)))
                )));
    }
}