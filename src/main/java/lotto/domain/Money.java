package lotto.domain;

import lotto.system.ExceptionMessage;
import lotto.system.SystemConstant;

public class Money {
    private final long value;

    private Money(long value) {
        validate(value);
        this.value = value;
    }

    public static Money from(long value) {
        return new Money(value);
    }

    private void validate(long value) {
        if (value % SystemConstant.LOTTO_TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_NOT_DIVISIBLE.getMessage());
        }
    }
}
