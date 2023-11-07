package lotto.domain;

import lotto.exception.money.MoneyRangeException;
import lotto.exception.money.MoneyUnitException;

public class Money {

    private static final long AMOUNT_PER_UNIT = 1000;
    private final long value;

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    public static Money from(long value) {
        return new Money(value);
    }

    private void validate(long value) {
        if (value < 1000) {
            throw new MoneyRangeException(value);
        }

        if (value % AMOUNT_PER_UNIT != 0) {
            throw new MoneyUnitException(value);
        }
    }

    public long getLottoCount() {
        return this.value / AMOUNT_PER_UNIT;
    }

    public long getValue() {
        return this.value;
    }

}
