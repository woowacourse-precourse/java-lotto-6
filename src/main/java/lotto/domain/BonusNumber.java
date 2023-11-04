package lotto.domain;

import java.util.Objects;

public class BonusNumber {
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위의 숫자만 입력 가능합니다.";

    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNumber that = (BonusNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
