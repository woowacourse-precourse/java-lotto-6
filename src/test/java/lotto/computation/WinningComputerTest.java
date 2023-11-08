package lotto.computation;

import lotto.domain.BonusNumber;
import lotto.domain.Winning;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningComputerTest {
    @DisplayName("로또 번호와 당첨 번호가 몇 개 일치하는지 계산할 수 있다.")
    @Test
    void computeMatchCountFromLottoNumbers() {
        // given
        List<Integer> lottoNumbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = List.of(40, 41, 42, 43, 44, 45);
        List<Integer> lottoNumbers3 = List.of(1, 10, 17, 28, 39, 45);
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 4, 5, 17, 39, 45));

        // when
        Winning winning1 = WinningComputer.computeMatchCount(lottoNumbers1, winningNumbers);
        Winning winning2 = WinningComputer.computeMatchCount(lottoNumbers2, winningNumbers);
        Winning winning3 = WinningComputer.computeMatchCount(lottoNumbers3, winningNumbers);

        // then
        assertThat(winning1).isEqualTo(Winning.THREE);
        assertThat(winning2).isEqualTo(Winning.NO_WINNING);
        assertThat(winning3).isEqualTo(Winning.FOUR);

    }

    @DisplayName("로또 번호와 보너스 번호가 일치하는지 계산할 수 있다.")
    @Test
    void computeMatchCountFromBonusNumber() {
        // given
        List<Integer> lottoNumbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = List.of(40, 41, 42, 43, 44, 45);
        List<Integer> lottoNumbers3 = List.of(1, 10, 17, 28, 39, 45);
        BonusNumber bonusNumber = new BonusNumber(45);

        // when
        Winning winning1 = WinningComputer.computeMatchCount(lottoNumbers1, bonusNumber);
        Winning winning2 = WinningComputer.computeMatchCount(lottoNumbers2, bonusNumber);
        Winning winning3 = WinningComputer.computeMatchCount(lottoNumbers3, bonusNumber);

        // then
        assertThat(winning1).isEqualTo(Winning.FIVE);
        assertThat(winning2).isEqualTo(Winning.FIVE_BONUS);
        assertThat(winning3).isEqualTo(Winning.FIVE_BONUS);
    }
}