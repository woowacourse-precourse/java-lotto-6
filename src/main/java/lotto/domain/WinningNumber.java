package lotto.domain;

import static common.enumtype.ErrorCode.WINNING_NUMBER_INVALID_RANGE;

import common.exception.InvalidArgumentException;
import java.util.Objects;

public class WinningNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public WinningNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public boolean equalsTo(int number) {
        return this.number == number;
    }

    private void validateNumber(int number) {
        if (!isValidRange(number)) {
            throw new InvalidArgumentException(WINNING_NUMBER_INVALID_RANGE);
        }
    }

    private boolean isValidRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumber that = (WinningNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
