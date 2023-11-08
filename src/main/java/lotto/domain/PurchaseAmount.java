package lotto.domain;

import lotto.util.ExceptionMessage;

public class PurchaseAmount {
    private final long amount;

    public PurchaseAmount(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) throws IllegalArgumentException {
        validatePurchaseLottoRange(amount);
        validatePurchaseLottoUnit(amount);
    }

    private void validatePurchaseLottoRange(long amount) {
        if (amount < Purchase.MIN_PURCHASE_LOTTO.amount) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MIN_RANGE.getMessage());
        }
        if (amount > Purchase.MAX_PURCHASE_LOTTO.amount) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MAX_RANGE.getMessage());
        }
    }

    private void validatePurchaseLottoUnit(long amount) {
        if (amount % Purchase.LOTTO_UNIT.amount != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public long calculateLottoCount() {
        return this.amount / Purchase.LOTTO_UNIT.amount;
    }

    public long getAmount() {
        return amount;
    }

    private enum Purchase {
        LOTTO_UNIT(1000L),
        MIN_PURCHASE_LOTTO(1000L),
        MAX_PURCHASE_LOTTO(9223372036854000L);

        private final long amount;

        Purchase(long amount) {
            this.amount = amount;
        }
    }
}
