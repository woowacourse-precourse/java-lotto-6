package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.WinningGrade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("당첨 숫자 조합 도메인에")
class WinningCombinationTest {

    @DisplayName("우승 정보 계산 요청시")
    @Nested
    class CalculateWinningLottos {

        @DisplayName("1등 1개인 경우 계산 후 해당하는 값을 가진다.")
        @Test
        void oneFirstWinning() {
            // given
            final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            final WinningCombination winningCombination =
                    new WinningCombination(new WinningNumbers(numbers), new BonusNumber(7));

            // when
            final WinningResult winningResult =
                    winningCombination.calculateWinningLottos(
                            new Lottos(List.of(new Lotto(numbers))));

            // then
            assertThat(winningResult.numOfWinningGrade(WinningGrade.FIRST_GRADE)).isEqualTo(1);
        }

        @DisplayName("1등 1개, 2등 1개인 경우 계산 후 해당하는 값을 가진다.")
        @Test
        void oneFirstWinningOneSecondWinning() {
            // given
            final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            final WinningCombination winningCombination =
                    new WinningCombination(new WinningNumbers(numbers), new BonusNumber(7));

            // when
            final WinningResult winningResult =
                    winningCombination.calculateWinningLottos(
                            new Lottos(
                                    List.of(
                                            new Lotto(numbers),
                                            new Lotto(List.of(1, 2, 3, 4, 5, 7)))));

            // then
            assertThat(winningResult.numOfWinningGrade(WinningGrade.FIRST_GRADE)).isEqualTo(1);
            assertThat(winningResult.numOfWinningGrade(WinningGrade.SECOND_GRADE)).isEqualTo(1);
        }

        @DisplayName("3등 1개, 낙첨 1개인 경우 계산 후 해당하는 값을 가진다.")
        @Test
        void oneThirdWInningOneNone() {
            // given
            final WinningCombination winningCombination =
                    new WinningCombination(
                            new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

            // when
            final WinningResult winningResult =
                    winningCombination.calculateWinningLottos(
                            new Lottos(
                                    List.of(
                                            new Lotto(List.of(1, 10, 11, 12, 13, 14)),
                                            new Lotto(List.of(1, 2, 3, 4, 5, 8)))));

            // then
            assertThat(winningResult.numOfWinningGrade(WinningGrade.THIRD_GRADE)).isEqualTo(1);
        }
    }

    @DisplayName("생성시 보너스 번호와 당첨 번호에 중복 값이 있으면 예외를 던진다.")
    @Test
    void createValidation() {
        // given
        // when
        // then
        assertThatThrownBy(
                        () ->
                                new WinningCombination(
                                        new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                                        new BonusNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
