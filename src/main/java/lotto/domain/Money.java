package lotto.domain;

public class Money {
    private final long value;

    private Money(long value) {
        validate(value);
        this.value = value;
    }

    public static Money from(long value) {
        return new Money(value);
    }

    private void validate(long value) {

    }
}
