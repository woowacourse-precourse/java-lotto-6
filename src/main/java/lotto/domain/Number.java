package lotto.domain;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(final int value) {
        this.value = value;
    }

    public static Number from(final int value) {
        return new Number(value);
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
