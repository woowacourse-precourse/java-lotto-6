package lotto.domain;

import java.math.BigDecimal;
import java.math.MathContext;

public record Statistic(double yieldRatio) {
    public static Statistic of(int paymentAmount,int prizeAmount){
        double yieldRatio = calculateYield(paymentAmount,prizeAmount);
        return new Statistic(yieldRatio);
    }
    private static Double calculateYield(int paymentAmount , int prizeAmount){
        BigDecimal payment = new BigDecimal(paymentAmount);
        BigDecimal prize = new BigDecimal(prizeAmount);
        double yieldRatio = prize.divide(payment, MathContext.DECIMAL128).
                                    multiply(BigDecimal.valueOf(100)).doubleValue();
        return yieldRatio;
    }
}
