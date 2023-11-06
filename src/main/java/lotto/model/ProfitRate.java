package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRate {


    private static final BigDecimal PERCENTAGE_MULTIPLIER = BigDecimal.valueOf(100);
    private static final int INITIAL_SCALE = 1;

    private final BigDecimal profitRate;

    public ProfitRate(final Money purchaseAmount, final BigDecimal totalAmount) {
        this.profitRate = totalAmount.multiply(PERCENTAGE_MULTIPLIER)
                .divide(purchaseAmount.getAmount(), INITIAL_SCALE, RoundingMode.HALF_EVEN);
    }

    public double doubleValue() {
        return profitRate.doubleValue();
    }
}
