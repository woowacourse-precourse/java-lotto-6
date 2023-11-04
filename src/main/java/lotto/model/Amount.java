package lotto.model;

import lotto.config.LottoConfig;
import lotto.Message.ErrorMessage;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        rangeValidate(amount);
        unitValidate(amount);

        this.amount = amount;
    }

    private void rangeValidate(int amount) {
        if (amount < LottoConfig.AMOUNT_VALUE_MIN.getValue() || amount > LottoConfig.AMOUNT_VALUE_MAX.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void unitValidate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}