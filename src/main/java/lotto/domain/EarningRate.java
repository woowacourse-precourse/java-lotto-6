package lotto.domain;

import lotto.constant.ErrorMessage;

public final class EarningRate {

    private static final int MIN_EARNING_VALUE = 0;
    private static final int PERCENT_MULTIPLY_UNIT = 100;
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
        return profit.doubleValue() / purchaseAmount.toValue() * PERCENT_MULTIPLY_UNIT;
    }

    public Double toValue() {
        return this.value;
    }
}
