package lotto.model;

import java.util.Objects;
import lotto.exception.InvalidLottoRangeException;
import lotto.exception.NonPositiveIntException;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int value;

    private Number(final int value) {
        this.value = value;
    }

    public static Number from(final String number) {
        validateNumericValue(number);
        int value = Integer.parseInt(number);
        validateRange(value);
        return new Number(value);
    }

    public static Number from(final int number) {
        validateRange(number);
        return new Number(number);
    }

    private static void validateNumericValue(final String value) {
        if (!isNumeric(value)) {
            throw new NonPositiveIntException();
        }
    }

    private static boolean isNumeric(final String value) {
        if (value.isEmpty()) {
            return false;
        }

        return value.chars()
                .allMatch(Character::isDigit);
    }

    private static void validateRange(final int number) {
        if (!isValidRange(number)) {
            throw new InvalidLottoRangeException();
        }
    }

    private static boolean isValidRange(final int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }
}
