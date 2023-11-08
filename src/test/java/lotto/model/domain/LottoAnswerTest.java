package lotto.model.domain;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.LottoAnswer;
import lotto.model.domain.result.compare.LottoAnswerCompareResult;
import lotto.model.domain.result.compare.LottoCompareResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoAnswerTest {

    @Test
    @DisplayName("정답에 중복된 숫자가 있으면 예외가 발생한다.")
    public void answerNumbersCantDuplicated() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoAnswer(List.of(1, 1, 2, 3, 4, 5), 8));
    }

    @Test
    @DisplayName("보너스 숫자가 정답에 있으면 예외가 발생한다.")
    public void bonusNumbersCantDuplicated() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 6));
    }

    @Test
    @DisplayName("정상적인 정답 생성")
    public void normalAnswerTest() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7));
    }


    @ParameterizedTest
    @MethodSource("equalsWithAnswerArgs")
    void 정답과_동등성_테스트(Lotto lotto, LottoAnswer answer, LottoCompareResult result) {
        Assertions.assertThat(answer.compareLotto(lotto))
                .isEqualTo(result);
    }

    static Stream<Arguments> equalsWithAnswerArgs() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 9),
                        new LottoAnswerCompareResult(6, false)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(2, 3, 4, 5, 6, 7), 10),
                        new LottoAnswerCompareResult(5, false)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(2, 3, 4, 5, 6, 7), 1),
                        new LottoAnswerCompareResult(5, true)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(7, 8, 9, 10, 11, 12), 6),
                        new LottoAnswerCompareResult(0, false)),

                Arguments.of(new Lotto(List.of(1, 3, 6, 15, 19, 31)),
                        new LottoAnswer(List.of(6, 11, 19, 23, 31, 42), 1),
                        new LottoAnswerCompareResult(3, false))
        );
    }

}