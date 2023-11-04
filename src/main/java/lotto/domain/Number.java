package lotto.domain;

import java.util.Objects;
import lotto.exception.InvalidRangeException;
import lotto.exception.NonPositiveIntException;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    private Number(int number) {
        this.number = number;
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
            throw new InvalidRangeException();
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
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
