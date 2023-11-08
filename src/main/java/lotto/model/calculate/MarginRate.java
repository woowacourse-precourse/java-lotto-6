package lotto.model.calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.model.money.Money;

public class MarginRate {
    private final BigDecimal marginRateData;

    public MarginRate(Money purchasingMoney, Money totalRevenue) {
        this.marginRateData = calculateMarginRate(purchasingMoney, totalRevenue);
    }

    public MarginRate(BigDecimal marginRateData) {
        this.marginRateData = marginRateData;
    }

    public BigDecimal getMarginRateData() {
        return marginRateData;
    }

    private BigDecimal calculateMarginRate(Money purchasingMoney, Money totalRevenue) {
        return totalRevenue.divideBy(purchasingMoney)
                .multiply(new BigDecimal(100))
                .setScale(1,RoundingMode.HALF_UP);
    }

    public BigDecimal seperateWholePart() {
        return this.marginRateData.setScale(0, RoundingMode.DOWN);
    }

    public BigDecimal seperatefractionalPart() {
        return this.marginRateData.subtract(seperateWholePart()).movePointRight(1);
    }
}
