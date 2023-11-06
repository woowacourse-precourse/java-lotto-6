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

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
