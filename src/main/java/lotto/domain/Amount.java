package lotto.domain;

import lotto.validation.AmountException;

public class Amount {
    private static final int AMOUNT_LEAST_VALUE = 1_000;

    private int value;

    public Amount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        isGreaterThanEqualLeastValue(value);
        isMultiple(value);
    }

    private void isGreaterThanEqualLeastValue(int value) {
        if (value < AMOUNT_LEAST_VALUE) {
            throw AmountException.LEAST_VALUE_EXCEPTION.getException();
        }
    }

    private void isMultiple(int value) {
        if (value % AMOUNT_LEAST_VALUE != 0) {
            throw AmountException.UNIT_EXCEPTION.getException();
        }
    }
}
