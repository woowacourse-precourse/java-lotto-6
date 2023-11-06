package lotto.domain;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public static Number from(final int value) {
        return new Number(value);
    }

    public int getValue() {
        return value;
    }
}
