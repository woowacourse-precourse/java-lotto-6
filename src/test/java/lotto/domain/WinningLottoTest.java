package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("정답 로또에 대한 테스트")
public class WinningLottoTest {
    @DisplayName("정상 정답 로또인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @MethodSource("validAnswerLottoProvider")
    void createAnswerLottoWithValid(Lotto lotto, BonusNumber bonus) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new WinningLotto(lotto, bonus));
    }

    static Stream<Arguments> validAnswerLottoProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(20, 39, 22, 40, 17, 32)), new BonusNumber(13),
                        Arguments.of(new Lotto(List.of(45, 1, 26, 12, 21, 8)), new BonusNumber(4)),
                        Arguments.of(new Lotto(List.of(7, 37, 19, 43, 5, 29)), new BonusNumber(35))
                )
        );
    }

    @DisplayName("보너스 숫자가 허용 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {LottoOption.LOTTO_START_INCLUSIVE - 1, LottoOption.LOTTO_END_INCLUSIVE + 1})
    void createAnswerLottoWithInvalidBonus(int number) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자와 보너스 숫자가 겹치는 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("duplicateNumberProvider")
    void createAnswerLottoWithDuplicate(Lotto lotto, BonusNumber bonus) {
        Assertions.assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> duplicateNumberProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(2, 43, 6, 29, 19, 34)), new BonusNumber(6)),
                Arguments.of(new Lotto(List.of(7, 28, 14, 44, 23, 3)), new BonusNumber(3)),
                Arguments.of(new Lotto(List.of(35, 16, 41, 25, 36, 13)), new BonusNumber(35))
        );
    }
    @DisplayName("로또 숫자에 대한 순위 계산에 문제가 없다")
    @ParameterizedTest
    @MethodSource("calculateLottoProvider")
    void calculateLottoTest(Lotto lotto, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        Rank actual = winningLotto.calculateLottoRank(lotto);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> calculateLottoProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 40)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 40)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 10, 20)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 30, 10, 20)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 12, 30, 10, 20)), Rank.NO_RANK)
        );
    }

    @DisplayName("로또 숫자에 대한 결과 계산에 문제가 없다")
    @Test
    void calculateResultTest() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 7, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10))
        ));

        ResultSheet resultSheet = winningLotto.calculateResult(lottos);
        Assertions.assertThat(resultSheet).isEqualTo(new ResultSheet(Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.NO_RANK, 0
        )));
    }
}
