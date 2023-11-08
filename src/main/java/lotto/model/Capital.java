package lotto.model;

import lotto.constant.ConsoleMessage;
import lotto.constant.LottoConstant;

public record Capital(int amount) {
    public Capital {
        validate(amount);
    }

    private void validate(int amount) {
        if (amount > LottoConstant.MAX_PURCHASE_AMOUNT || amount <= 0) {
            throw new IllegalArgumentException(ConsoleMessage.AMOUNT_OUT_OF_RANGE_ERROR_MESSAGE);
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ConsoleMessage.INVALID_INPUT_AMOUNT_ERROR_MESSAGE);
        }
    }

    public int getNumberOfPurchasedLotto() {
        return amount / 1000;
    }
}
