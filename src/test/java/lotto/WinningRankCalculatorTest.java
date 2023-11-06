package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningRankCalculatorTest {

    @DisplayName("로또와 당첨번호, 보너스 번호를 가지고 등수를 결정한다.")
    @Test
    void determineWinningRank() {
        Lotto lotto = new Lotto(List.of(2, 3, 4, 5, 6, 8));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(8);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumber, bonusNumber);
        WinningRankCalculator winningRankCalculator = new WinningRankCalculator();

        //when
        WinningRank actualWinningRank = winningRankCalculator.determineWinningRank(lotto, lottoWinningNumbers);

        //then
        assertThat(actualWinningRank)
                .isEqualTo(WinningRank.SECOND);
    }
}