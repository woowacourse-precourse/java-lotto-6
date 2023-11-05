package lotto.model;

import lotto.common.constants.LottoRule;
import lotto.common.exception.ErrorMessage;

public class LottoPurchaseAmount {
    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validatePurchaseAmountRange(amount);
        validatePurchaseAmountUnit(amount);
        this.amount = amount;
    }

    private void validatePurchaseAmountUnit(int amount) {
        if (amount % LottoRule.LOTTO_PURCHASE_AMOUNT_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getValue(amount));
        }
    }

    private void validatePurchaseAmountRange(int amount) {
        if (amount < LottoRule.LOTTO_PURCHASE_AMOUNT_MIN.getValue()
                || LottoRule.LOTTO_PURCHASE_AMOUNT_MAX.getValue() < amount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getValue(amount));
        }
    }

    public int getValue() {
        return amount;
    }

    @Override
    public String toString() {
        return "LottoPurchaseAmount{" +
                "amount=" + amount +
                '}';
    }
}
