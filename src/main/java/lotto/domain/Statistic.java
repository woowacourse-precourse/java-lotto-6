package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Statistic(double yieldRatio) {
    public static Statistic of(int paymentAmount,int prizeAmount){
        double yieldRatio = calculateYield(paymentAmount,prizeAmount);
        return new Statistic(yieldRatio);
    }
    private static Double calculateYield(int paymentAmount , int prizeAmount){
        BigDecimal payment = BigDecimal.valueOf(paymentAmount);
        BigDecimal prize = BigDecimal.valueOf(prizeAmount);
        return prize.divide(payment, 4, RoundingMode.HALF_UP) // 소수점 두 자리에서 반올림
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue(); // 결과를 double 타입으로 변환
    }
}
