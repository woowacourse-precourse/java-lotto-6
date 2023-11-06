package lotto.domain;

import static lotto.constant.LottoConstant.PURCHASE_AMOUNT_UNIT;
import static lotto.constant.LottoErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE;

public class Amount {
    private final int amount;
    private final int count;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
        count = amount / PURCHASE_AMOUNT_UNIT;
    }

    private void validate(int amount) {
        if (amount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
}
