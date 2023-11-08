package lotto.domain;

import lotto.utils.message.PurchaseAmountExceptionMessage;

public class PurchaseAmount {

    private static final int MINIMUM = 1_000;
    private static final int MAXIMUM = 100_000_000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateRange(amount);
    }

    private void validateRange(int amount) {
        if (amount < MINIMUM || amount > MAXIMUM) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.OUT_OF_AMOUNT_RANGE.getError());
        }
    }
}
