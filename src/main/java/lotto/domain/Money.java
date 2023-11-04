package lotto.domain;

import lotto.message.ExceptionMessage;

public class Money {
    private final int value;

    public Money(int value) {
        validateIsDivisibleBy1000(value);
        this.value = value;
    }

    private void validateIsDivisibleBy1000(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIVISIBLE_BY_1000.toString());
        }
    }

    public int getValue() {
        return value;
    }
}
