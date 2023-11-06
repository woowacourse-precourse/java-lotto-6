package lotto.domain;

import lotto.validator.PaymentValidator;

public class Payment {

    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Payment(final String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(final String amount) {
        PaymentValidator.validate(amount);
    }

    public int calculatePurchasedLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public double calculateYield(final long totalReward) {
        return Math.round((double) totalReward / amount * 1000) / 10.0;
    }

}
