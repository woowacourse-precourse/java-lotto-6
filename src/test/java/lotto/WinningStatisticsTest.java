package lotto;

import static lotto.Ranking.FIFTH;
import static lotto.Ranking.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 수익률이_정상적으로_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(new LottoAmount(10_000), Map.of(FIFTH, 3, NONE, 7));
        double returnRate = 50;

        assertThat(winningStatistics.getReturnRate()).isEqualTo(returnRate);
    }

    @Test
    void 수익률이_마이너스인_경우_정상적으로_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(new LottoAmount(6000), Map.of(NONE, 6));
        double returnRate = -100;

        assertThat(winningStatistics.getReturnRate()).isEqualTo(returnRate);
    }
}
