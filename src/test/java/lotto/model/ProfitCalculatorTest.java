package lotto.model;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    @DisplayName("로또 수익률을 반환하는 테스트")
    @Test
    void 수익률_테스트() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        Long properties = 2000L;
        PurchaseAmount amount = new PurchaseAmount("1000");
        Double expectedProfit = 200.0;

        Double calculatedProfit = profitCalculator.calculateProfit(properties, amount);

        assertThat(calculatedProfit).isEqualTo(expectedProfit);
    }
}