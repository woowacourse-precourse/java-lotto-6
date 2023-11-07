package lotto.domain;

import lotto.exception.Non1000WonUnitException;
import lotto.message.ExceptionMessage;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final int THOUSAND_WON_UNIT = 0;
    private final int value;

    public Money(int value) {
        validateIsDivisibleBy1000(value);
        this.value = value;
    }

    private void validateIsDivisibleBy1000(int value) {
        if (is1000WonUnit(value)) {
            String message = ExceptionMessage.IS_NOT_DIVISIBLE_BY_1000.toString();
            throw new Non1000WonUnitException(message);
        }
    }

    private boolean is1000WonUnit(int value) {
        return value % LOTTO_PRICE != THOUSAND_WON_UNIT;
    }

    public int convertMoneyToCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }
}
