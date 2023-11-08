package lotto.model.user;

import static lotto.util.message.ErrorMessages.USER_MONEY_UNIT_EXCEPTION;

public class UserMoney {
    private static final int LOTTO_PRICE = 1000;

    long amount;

    public UserMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(USER_MONEY_UNIT_EXCEPTION);
        }
    }

    public long getLottoAmount() {
        return this.amount / LOTTO_PRICE;
    }

    public double getRevenueRate(long prize) {
        if (prize != 0) {
            return Math.round((double) this.amount / prize * 100) / 100.0;
        }
        return 0.0;
    }
}
