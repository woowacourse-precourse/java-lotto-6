package lotto.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitCalculator {
    private static final int PERCENT = 100;
    private static final int SCALE = 3;
    public static float calculateLottoReturnRate(int totalCost, long totalPrize) {
        if (totalPrize <= 0) {
            return 0f;
        }
        if (totalCost == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        BigDecimal prize = new BigDecimal(totalPrize);
        BigDecimal cost = new BigDecimal(totalCost);
        BigDecimal returnRate = prize.divide(cost, SCALE, RoundingMode.HALF_UP).multiply(new BigDecimal(PERCENT));

        return returnRate.floatValue();
    }
}
