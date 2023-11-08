package lotto.domain.number;

import java.util.Objects;

public class Number {
    private static final String INVALID_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private final int value;

    public Number(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MINIMUM || value > MAXIMUM) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
