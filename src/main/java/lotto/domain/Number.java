package lotto.domain;

import java.util.Objects;
import lotto.utils.NumberConstants;

public class Number {
    private int value;

    public Number(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        isInRange(value);
    }

    private void isInRange(int value) {
        if (value < NumberConstants.NUMBER_LEAST_VALUE.getValue()
            || value > NumberConstants.NUMBER_MOST_VALUE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 번호는 1이상 45이하의 수만 입력할 수 있습니다.");
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
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
