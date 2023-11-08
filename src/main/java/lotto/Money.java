package lotto;

import lotto.exception.ExceptionMessage;

public record Money(int amount) {
    private static final int MINIMAL_UNIT = 1_000;

    public Money {
        validate(amount);
    }

    private void validate(final int amount) {
        validateUnit(amount);
        validateNotZero(amount);
    }

    private void validateUnit(final int amount) {
        if (amount % MINIMAL_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.UNIT_ERROR.getMessage());
        }
    }

    private void validateNotZero(final int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ExceptionMessage.ZERO_VALUE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount;
    }

    public int perUnit() {
        return amount / MINIMAL_UNIT;
    }
}
