package lotto;

import lotto.domain.YieldRate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YieldRateTest {
    @Test
    void 수익률_계산_테스트() {
        YieldRate yieldRate = new YieldRate(3000, 6000);
        assertThat(yieldRate.getYieldRate()).isEqualTo(200.0);
    }

    @Test
    void 수익률_반올림_테스트() {
        YieldRate yieldRate = new YieldRate(8000, 5000);
        assertThat(yieldRate.getYieldRate()).isEqualTo(62.5);
    }
}
