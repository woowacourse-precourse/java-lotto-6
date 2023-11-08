package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String NUMBER_ERROR_MESSAGE = "1~45 사이의 수를 입력해주세요";
    private static final int UPPER_BOUND_NUMBER = 45;
    private static final int LOWER_BOUND_NUMBER = 1;

    private final int value;

    public LottoNumber(int value) {
        if (isInvalidNumber(value)) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    private boolean isInvalidNumber(int value) {
        return value < LOWER_BOUND_NUMBER || value > UPPER_BOUND_NUMBER;
    }
}
