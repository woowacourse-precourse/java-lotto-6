package lotto.domain.model.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.lotto.PaidAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorTest {

    @DisplayName("1등과 3등 한번 당첨되었을지 수익률이 총 당첨금액/지불금액과 같다.")
    @Test
    void calculateProfitRate() {
        WinningRankCounts winningRankCounts = new WinningRankCounts();
        winningRankCounts.incrementCount(WinningRank.FIRST);
        winningRankCounts.incrementCount(WinningRank.THIRD);
        winningRankCounts.incrementCount(WinningRank.NO_WIN);
        PaidAmount paidAmount = new PaidAmount(3000);

        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        double expectedRate = (double) (WinningRank.FIRST.getPrize() + WinningRank.THIRD.getPrize()) / 3000 * 100;

        //when
        double profitRate = profitRateCalculator.calculate(winningRankCounts, paidAmount);

        //then
        assertThat(profitRate)
                .isEqualTo(expectedRate);
    }
}