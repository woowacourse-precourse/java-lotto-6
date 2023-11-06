package lotto.domain;

import lotto.global.constant.message.ErrorMessage;
import lotto.global.exception.LottoIllegalArgumentException;

public class Money {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }


    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        validateIsAmountZero(amount);
    }

    private void validateIsAmountZero(int amount) {
        if (amount == 0) {
            throw new LottoIllegalArgumentException(ErrorMessage.MONEY_AMOUNT_ERROR);
        }
    }
}
