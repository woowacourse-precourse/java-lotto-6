package lotto.model;

import static lotto.util.message.ErrorMessages.USER_MONEY_UNIT_EXCEPTION;

public class UserMoney {
    int amount;

    public UserMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(USER_MONEY_UNIT_EXCEPTION);
        }
    }
}
