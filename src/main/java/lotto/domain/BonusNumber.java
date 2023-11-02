package lotto.domain;

import static lotto.exception.ExceptionMessage.LottoException.BONUS_NUMBER_IS_NOT_IN_RANGE;

public class BonusNumber {
    private final int value;

    private BonusNumber(final int value) {
        this.value = value;
    }

    public static BonusNumber create(final int value) {
        validateBonusNumberIsInRange(value);
        return new BonusNumber(value);
    }

    private static void validateBonusNumberIsInRange(final int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_IN_RANGE.message);
        }
    }

    private static boolean isOutOfRange(final int value) {
        return value < Lotto.LOWER_BOUND || value > Lotto.UPPER_BOUND;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final BonusNumber other = (BonusNumber) object;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }
}
