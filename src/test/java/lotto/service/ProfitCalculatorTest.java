package lotto.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitCalculatorTest {

    @Test
    void testCalculateProfitWithZeroInput() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profit = profitCalculator.calculateProfit(0, 0);
        assertEquals(0.0, profit);
    }

    @Test
    void testCalculateProfit() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profit = profitCalculator.calculateProfit(8000, 5000);
        assertEquals(62.5, profit);
    }

    @Test
    void testCalculateProfitWithRounding() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profit = profitCalculator.calculateProfit(1000000, 515000);
        assertEquals(51.5, profit);
    }
}
