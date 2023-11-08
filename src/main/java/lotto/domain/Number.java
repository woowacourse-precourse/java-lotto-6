package lotto.domain;

import java.util.Objects;

public class Number {

    private static final int LOTTO_MAX_NUM = 45;
    private static final String ERROR_HEAD = "[ERROR] ";

    private final int value;

    private Number(final int value) {
        this.value = value;
    }

    public static Number from(final int value) {
        validRange(value);
        return new Number(value);
    }

    private static void validRange(final int value) {
        boolean overRange = value > LOTTO_MAX_NUM;
        if (overRange) {
            throw new IllegalArgumentException(ERROR_HEAD + "로또 번호의 범위는 45입니다!");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
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
