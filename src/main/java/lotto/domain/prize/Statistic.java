package lotto.domain.prize;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Statistic(double yieldRatio) {
    public static Statistic of(int paymentAmount, int prizeAmount) {
        double yieldRatio = calculateYield(paymentAmount, prizeAmount);
        return new Statistic(yieldRatio);
    }

    private static Double calculateYield(int paymentAmount, int prizeAmount) {
        BigDecimal payment = BigDecimal.valueOf(paymentAmount);
        BigDecimal prize = BigDecimal.valueOf(prizeAmount);
        return prize.divide(payment, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
