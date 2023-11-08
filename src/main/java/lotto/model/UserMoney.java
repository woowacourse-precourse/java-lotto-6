package lotto.model;

import static lotto.util.message.ErrorMessages.USER_MONEY_UNIT_EXCEPTION;

public class UserMoney {
    private static final int LOTTO_PRICE = 1000;

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

    public int getLottoAmount() {
        return amount / LOTTO_PRICE;
    }

    public float getRevenueRate(long prize) {
        return (float) (Math.round((float) amount / prize * 100) / 100.0);
    }
}
