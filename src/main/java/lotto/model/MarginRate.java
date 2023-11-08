package lotto.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MarginRate {
    private final double marginRate;

    public MarginRate(Money purchasingMoney, Money totalRevenue) {
        this.marginRate = calculateMarginRate(purchasingMoney, totalRevenue);
    }

    public double getMarginRate() {
        return marginRate;
    }

    private double calculateMarginRate(Money purchasingMoney, Money totalRevenue) {
        return totalRevenue.divideBy(purchasingMoney)
                .multiply(new BigDecimal(100))
                .round(new MathContext(3, RoundingMode.HALF_UP))
                .doubleValue();
    }
}
