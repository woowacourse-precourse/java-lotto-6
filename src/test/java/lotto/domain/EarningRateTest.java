package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class EarningRateTest {
    @DisplayName("수익률 계산 테스트")
    @Test
    void testEarningRate() {
        EarningRate earningRate = new EarningRate();
        assertThat(earningRate.calculateEarningRate(List.of(3, 3))).isEqualTo(10000);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void testEarningRate2() {
        EarningRate earningRate = new EarningRate();
        assertThat(earningRate.calculateEarningRate(List.of(5, 7))).isEqualTo(1500000 + 30000000);
    }
}
