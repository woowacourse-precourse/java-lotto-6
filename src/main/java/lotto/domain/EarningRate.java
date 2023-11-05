package lotto.domain;

import lotto.constant.ErrorMessage;

public class EarningRate {

    private static final int MIN_EARNING_VALUE = 0;
    private final Double value;

    public EarningRate(final Integer profit, final PurchaseAmount purchaseAmount) {
        validate(profit);
        this.value = calculateEarningRate(profit, purchaseAmount);
    }

    private void validate(final Integer profit) {
        if (profit < MIN_EARNING_VALUE) {
            throw new IllegalStateException(ErrorMessage.NOT_POSITIVE_PROFIT.toValue());
        }
    }

    private double calculateEarningRate(final Integer profit, final PurchaseAmount purchaseAmount) {
        return profit.doubleValue() / purchaseAmount.toValue();
    }

    public Double toValue() {
        return this.value;
    }
}
