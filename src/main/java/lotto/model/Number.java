package lotto.model;

import static lotto.util.Constants.MAX_NUMBER_RANGE;
import static lotto.util.Constants.MIN_NUMBER_RANGE;

import java.util.Objects;
import lotto.exception.ErrorType;

public class Number implements Comparable<Number> {

    private int number;

    public Number(int number) {
        validateRangeNumber(number);
        this.number = number;
    }

    private void validateRangeNumber(int number) {
        if (isInRange(number)) {
            throw new IllegalArgumentException(ErrorType.INVALID_IN_RANGE.getMessage());
        }
    }

    private boolean isInRange(int number) {
        return number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE;
    }

    public int getNumber() {
        return number;
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

    @Override
    public int compareTo(Number o) {
        return this.number - o.number;
    }
}
