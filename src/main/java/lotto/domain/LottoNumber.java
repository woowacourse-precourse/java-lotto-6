package lotto.domain;

import static lotto.utils.ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_BOUND || number > MAX_BOUND) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
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
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
