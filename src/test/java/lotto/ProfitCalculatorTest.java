package lotto;

import lotto.model.ProfitCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitCalculatorTest {
    @DisplayName("수익률 테스트")
    @Test
    void calculateProfitRate() {
        long purchasedAmount = 8000;
        long totalAmount = 5000;

        double calculatedProfitRate = ProfitCalculator.calculate(purchasedAmount, totalAmount);

        assertEquals(62.5, calculatedProfitRate);
    }

    @DisplayName("수익률 - 구입금액이 0이라면?")
    @Test
    void calculateProfitRate_IfZero() {
        long purchasedAmount = 0;
        long totalAmount = 5000;

        double calculatedProfitRate = ProfitCalculator.calculate(purchasedAmount, totalAmount);

        assertEquals(0.0, calculatedProfitRate);
    }
}
