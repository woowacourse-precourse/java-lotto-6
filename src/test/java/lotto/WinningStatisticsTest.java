package lotto;

import static lotto.Ranking.FIFTH;
import static lotto.Ranking.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 수익률이_정상적으로_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(Map.of(FIFTH, 3, NONE, 7));
        int amount = 10_000;
        double returnRate = 50;

        assertThat(winningStatistics.getReturnRate(amount)).isEqualTo(returnRate);
    }

    @Test
    void 수익률이_마이너스인_경우_정상적으로_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(Map.of(NONE, 6));
        int amount = 6000;
        double returnRate = -100;

        assertThat(winningStatistics.getReturnRate(amount)).isEqualTo(returnRate);
    }
}
