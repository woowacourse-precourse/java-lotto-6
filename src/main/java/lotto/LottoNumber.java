package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_NUMBER || value > MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 숫자가 " + MIN_NUMBER + " ~ " + MAX_VALUE + " 내의 값이 아닙니다.");
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }
}
