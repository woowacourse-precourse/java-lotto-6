package lotto.domain;

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

}
