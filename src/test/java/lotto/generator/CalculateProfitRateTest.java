package lotto.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculateProfitRateTest {
    @DisplayName("수익률을 계산한다")
    @Test
    void testCalculateProfitRate() {
        // Arrange
        int totalProfit = 15000;
        int t = 10;

        // Act
        float profitRate = CalculateProfitRate.calculateProfitRate(totalProfit, t);

        // Assert
        assertThat(profitRate).isEqualTo(150.0f);
    }
}
