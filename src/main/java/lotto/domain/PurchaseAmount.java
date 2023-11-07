package lotto.domain;

import lotto.util.ExceptionMessage;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) throws IllegalArgumentException {
        validatePurchaseLottoRange(amount);
        validatePurchaseLottoUnit(amount);
    }

    private void validatePurchaseLottoRange(int amount) {
        if (amount < Range.MIN_PURCHASE_LOTTO.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MIN_RANGE.getMessage());
        }
        if (amount > Range.MAX_PURCHASE_LOTTO.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MAX_RANGE.getMessage());
        }
    }

    private void validatePurchaseLottoUnit(int amount) {
        if (amount % Range.LOTTO_UNIT.value != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public int calculateLottoCount() {
        return this.amount / Range.LOTTO_UNIT.value;
    }

    public int getAmount() {
        return getAmount();
    }

    private enum Range {
        LOTTO_UNIT(1000),
        MIN_PURCHASE_LOTTO(1000),
        MAX_PURCHASE_LOTTO(2147483000);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }
}
