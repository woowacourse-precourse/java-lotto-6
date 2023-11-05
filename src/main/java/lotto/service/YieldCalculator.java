package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.FinalGrade;

public class YieldCalculator {

    private static final int ROUND_SCALE = 1;
    private static final RoundingMode ROUND_MODE = RoundingMode.HALF_UP;
    private static final long MULTIPLY = 100L;

    public BigDecimal calculate(final FinalGrade finalGrade) {
        BigDecimal totalPrize = finalGrade.getPlayerTotalPrize();
        BigDecimal purchaseAmount = finalGrade.getPlayerTotalPurchaseAmount();

        totalPrize = totalPrize.multiply(new BigDecimal(MULTIPLY));
        return totalPrize.divide(purchaseAmount, ROUND_SCALE, ROUND_MODE);
    }
}
