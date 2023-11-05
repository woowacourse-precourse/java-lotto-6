package lotto.domain;

import static common.ErrorCode.AMOUNT_LESS_THAN_MINIMUM;

import common.exception.InvalidArgumentException;

public class Amount {

    private static final int MINIMUM_MONEY = 1000;
    private final int amount;

    public Amount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < MINIMUM_MONEY) {
            throw new InvalidArgumentException(AMOUNT_LESS_THAN_MINIMUM);
        }
    }
}
