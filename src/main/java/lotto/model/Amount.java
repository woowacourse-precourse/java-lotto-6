package lotto.model;

import static lotto.config.LottoConfig.AMOUNT_VALUE_MIN;
import static lotto.config.LottoConfig.AMOUNT_VALUE_MAX;
import static lotto.Message.ErrorMessage.AMOUNT_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.AMOUNT_UNIT_ERROR_MESSAGE;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        rangeValidate(amount);
        unitValidate(amount);

        this.amount = amount;
    }

    private void rangeValidate(int amount) {
        if (amount < AMOUNT_VALUE_MIN.getValue() || amount > AMOUNT_VALUE_MAX.getValue()) {
            throw new IllegalArgumentException(AMOUNT_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void unitValidate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}