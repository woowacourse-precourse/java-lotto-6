package lotto.domain;

import static lotto.constants.Error.INVALID_AMOUNT_ERROR;
import static lotto.constants.Error.ZERO_ERROR;
import static lotto.constants.Value.REMAINDER_ZERO;
import static lotto.constants.Value.UNIT_OF_AMOUNT;
import static lotto.constants.Value.ZERO;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateUnit(amount);
        validateNonZero(amount);
        this.amount = amount;
    }

    public int countNumberOfLotto() {
        return amount / UNIT_OF_AMOUNT.get();
    }

    public void validateUnit(int amount) {
        if (amount % UNIT_OF_AMOUNT.get() != REMAINDER_ZERO.get()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR.getMessage());
        }
    }

    public void validateNonZero(int amount) {
        if (amount == ZERO.get()) {
            throw new IllegalArgumentException(ZERO_ERROR.getMessage());
        }
    }
}
