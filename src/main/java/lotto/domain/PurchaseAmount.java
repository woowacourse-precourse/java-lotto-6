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
        if (amount < Purchase.MIN_PURCHASE_LOTTO.amount) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MIN_RANGE.getMessage());
        }
        if (amount > Purchase.MAX_PURCHASE_LOTTO.amount) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MAX_RANGE.getMessage());
        }
    }

    private void validatePurchaseLottoUnit(int amount) {
        if (amount % Purchase.LOTTO_UNIT.amount != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public int calculateLottoCount() {
        return this.amount / Purchase.LOTTO_UNIT.amount;
    }

    public int getAmount() {
        return amount;
    }

    private enum Purchase {
        LOTTO_UNIT(1000),
        MIN_PURCHASE_LOTTO(1000),
        MAX_PURCHASE_LOTTO(2147483000);

        private final int amount;

        Purchase(int amount) {
            this.amount = amount;
        }
    }
}
