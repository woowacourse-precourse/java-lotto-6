package lotto.domain;

import static lotto.domain.Ranking.FIFTH;
import static lotto.domain.Ranking.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 수익률이_정상적으로_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(new LottoAmount(10_000), Map.of(FIFTH, 3));
        BigDecimal returnRate = BigDecimal.valueOf(150.0);

        assertThat(winningStatistics.getReturnRate()).isEqualTo(returnRate);
    }

    @Test
    void 수익률이_소수점_2자리에서_반올림되어_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(new LottoAmount(16_000), Map.of(FIFTH, 1));
        BigDecimal returnRate = BigDecimal.valueOf(31.3); // 실제 값은 31.25

        assertThat(winningStatistics.getReturnRate()).isEqualTo(returnRate);
    }

    @Test
    void 수익률이_충분히_큰_경우_적절하게_반환되는가() {
        WinningStatistics winningStatistics = new WinningStatistics(new LottoAmount(16_000), Map.of(FIRST, 1));
        BigDecimal returnRate = BigDecimal.valueOf(12_500_000.0)
                .setScale(1, RoundingMode.HALF_UP); // 실제 값은 1.25E7

        assertThat(winningStatistics.getReturnRate()).isEqualTo(returnRate);
    }
}
