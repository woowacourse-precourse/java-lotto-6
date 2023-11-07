package lotto.domain;

import lotto.util.ExceptionMessage;
import lotto.util.enumerator.LottoNumberRange;

public class PurchaseAmount {
    private static final int LOTTO_UNIT = 1000;

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
        if (amount < LottoNumberRange.MIN_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MIN_RANGE.getMessage());
        }
        if (amount > LottoNumberRange.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_MAX_RANGE.getMessage());
        }
    }

    private void validatePurchaseLottoUnit(int amount) {
        if (amount % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public int calculateLottoCount() {
        return this.amount / LOTTO_UNIT;
    }

    public int getAmount() {
        return amount;
    }
}
