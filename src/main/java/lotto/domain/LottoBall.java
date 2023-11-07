package lotto.domain;

import lotto.exception.ArgumentRangeOutOfBoundsException;

public class LottoBall {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;

    private final int number;

    public LottoBall(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public boolean equals(LottoBall ball) {
        return this.number == ball.getNumber();
    }

    public Integer getNumber() {
        return number;
    }

    private void validateNumberRange(int number) {
        validateNumberLowerRange(number);
        validateNumberUpperRange(number);
    }

    private void validateNumberLowerRange(int number) {
        if (number < MIN_RANGE) {
            throw new ArgumentRangeOutOfBoundsException();
        }
    }

    private void validateNumberUpperRange(int number) {
        if (number > MAX_RANGE) {
            throw new ArgumentRangeOutOfBoundsException();
        }
    }
}
