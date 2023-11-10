package lotto.model.purchase;

import lotto.common.constants.LottoRule;
import lotto.common.exception.ErrorMessage;

public class LottoPurchaseAmount {
    private final int amount;

    protected LottoPurchaseAmount(int amount) {
        validatePurchaseAmountRange(amount);
        validatePurchaseAmountUnit(amount);
        this.amount = amount;
    }

    public static LottoPurchaseAmount from(int amount) {
        return new LottoPurchaseAmount(amount);
    }

    private void validatePurchaseAmountUnit(int amount) {
        if (amount % LottoRule.LOTTO_PURCHASE_AMOUNT_UNIT.value != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getValue(amount));
        }
    }

    private void validatePurchaseAmountRange(int amount) {
        if (amount < LottoRule.LOTTO_PURCHASE_AMOUNT_MIN.value
                || LottoRule.LOTTO_PURCHASE_AMOUNT_MAX.value < amount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getValue(amount));
        }
    }

    public int getValue() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoPurchaseAmount that = (LottoPurchaseAmount) o;

        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    @Override
    public String toString() {
        return "LottoPurchaseAmount{" +
                "amount=" + amount +
                '}';
    }

    public int calculatePurchaseLottoCount() {
        return amount / LottoRule.LOTTO_PURCHASE_AMOUNT_UNIT.value;
    }
}
