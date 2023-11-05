package lotto.model;

import static lotto.model.SystemConstant.LOTTO_PRICE;
import static lotto.model.SystemConstant.MIN_PURCHASE_PRICE;
import static lotto.view.ErrorMessage.LESS_MONEY;
import static lotto.view.ErrorMessage.NOT_DIVISIBLE_MONEY;

public class Money {
    private long amount;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        validateGreaterThanMinValue(amount);
        validateDivisibleByDefault(amount);
    }

    private void validateGreaterThanMinValue(long amount) {
        if (amount < MIN_PURCHASE_PRICE) {
            throw new IllegalArgumentException(LESS_MONEY.getMessage());
        }
    }

    private void validateDivisibleByDefault(long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_MONEY.getMessage());
        }
    }

    public long getAmount() {
        return this.amount;
    }
}
