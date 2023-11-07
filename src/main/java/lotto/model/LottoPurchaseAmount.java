package lotto.model;

import lotto.common.constants.LottoRule;
import lotto.common.exception.LottoErrorMessage;

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
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getValue(amount));
        }
    }

    private void validatePurchaseAmountRange(int amount) {
        if (amount < LottoRule.LOTTO_PURCHASE_AMOUNT_MIN.value
                || LottoRule.LOTTO_PURCHASE_AMOUNT_MAX.value < amount) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getValue(amount));
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

    public int calculateTotalLottos() {
        return amount / LottoRule.LOTTO_PURCHASE_AMOUNT_UNIT.value;
    }
}
