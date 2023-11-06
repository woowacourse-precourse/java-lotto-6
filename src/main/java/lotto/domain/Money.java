package lotto.domain;

public class Money {
    private static final int MIN_POSITIVE_RANGE = 1;

    private final int amount;

    private Money(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    private void validate(final int amount) {
        validatePositive(amount);
    }

    private void validatePositive(final int amount) {
        if (isNotPositive(amount)) {
            throw new IllegalArgumentException("로또 구입 금액은 양수여야 합니다.");
        }
    }

    private boolean isNotPositive(final int amount) {
        return amount < MIN_POSITIVE_RANGE;
    }
}
