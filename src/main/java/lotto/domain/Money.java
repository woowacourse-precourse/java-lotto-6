package lotto.domain;

public class Money {
    private final int value;

    private Money(final int value) {
        this.value = value;
    }

    public static Money from(final int value) {
        return new Money(value);
    }

    public int getValue() {
        return value;
    }
}
