package lotto.domain;

import static lotto.domain.Ranking.FIFTH;
import static lotto.domain.Ranking.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 수익률이_정상적으로_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(new LottoAmount(10_000), Map.of(FIFTH, 3));
        double returnRate = 150;

        assertThat(winningStatistics.getReturnRate()).isEqualTo(returnRate);
    }

    @Test
    void 수익률이_소수점_2자리에서_반올림되어_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(new LottoAmount(16_000), Map.of(FIFTH, 1));
        double returnRate = 31.3; // 실제 값은 31.25

        assertThat(winningStatistics.getReturnRate()).isEqualTo(returnRate);
    }
}
