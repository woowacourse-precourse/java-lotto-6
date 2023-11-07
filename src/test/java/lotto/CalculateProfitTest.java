package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.service.CalculateProiftService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateProfitTest {
    @DisplayName("수익률 계산")
    @Test
    void calculateProfit() {
        int winPrice = 5000;
        int buyPrice = 8000;
        CalculateProiftService service = new CalculateProiftService();

        double result = service.calculateProfit(winPrice, buyPrice);

        assertThat(String.format("%.1f", result)).isEqualTo("62.5");
    }
}
