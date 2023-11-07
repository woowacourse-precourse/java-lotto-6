package lotto.model;

import lotto.utils.Constants;
import lotto.utils.message.ErrorMessage;

public class Amount {

    private int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount from(int amount) {
        validateAmountUnit(amount);
        validateIsZero(amount);
        return new Amount(amount);
    }

    private static void validateAmountUnit(int amount) {
        if (amount % Constants.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_UNIT.getMessage());
        }
    }

    private static void validateIsZero(int amount) {
        if (amount == Constants.NO_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NO_AMOUNT.getMessage());
        }
    }

    public int getLottoCount() {
        return amount / Constants.LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
