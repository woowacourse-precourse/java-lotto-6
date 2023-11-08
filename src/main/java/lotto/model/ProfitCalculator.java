package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitCalculator {

    public static double calculate(long purchasedAmount, long totalAmount) {
        if (purchasedAmount == 0) {
            return 0.0;
        }

        double profitRate = (double) totalAmount / purchasedAmount;

        double profitRatePercentage = profitRate * 100.0;

        BigDecimal roundedProfitRate = BigDecimal.valueOf(profitRatePercentage).setScale(2, RoundingMode.HALF_UP);

        return roundedProfitRate.doubleValue();
    }
}
