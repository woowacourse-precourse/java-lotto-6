package lotto.domain;

import lotto.utils.message.PurchaseAmountExceptionMessage;

public class PurchaseAmount {

    private static final int MINIMUM = 1_000;
    private static final int MAXIMUM = 100_000_000;
    private static final int LOTTO_PRICE_UNIT = 1_000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(int amount) {
        if (amount < MINIMUM || amount > MAXIMUM) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.OUT_OF_AMOUNT_RANGE.getError());
        }
    }

    private void validateUnit(int amount) {
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.INVALID_AMOUNT_UNIT.getError());
        }
    }

    public int getPurchaseLottoCount() {
        return amount / LOTTO_PRICE_UNIT;
    }
}
