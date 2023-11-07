package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("1등과 3등 한번 당첨되었을지 수익률이 총 당첨금액/지불금액과 같다.")
    @Test
    void calculateProfitRate() {
        WinningCounts winningCounts = new WinningCounts();
        winningCounts.incrementCount(WinningRank.FIRST);
        winningCounts.incrementCount(WinningRank.THIRD);
        winningCounts.incrementCount(WinningRank.NO_WIN);
        PaidAmount paidAmount = new PaidAmount(3000);

        WinningStatistics winningStatistics = new WinningStatistics(winningCounts, paidAmount);
        double expectedRate = (double) (WinningRank.FIRST.getPrize() + WinningRank.THIRD.getPrize()) / 3000 * 100;

        //when
        double profitRate = winningStatistics.calculateProfitRate();

        //then
        assertThat(profitRate)
                .isEqualTo(expectedRate);
    }
}