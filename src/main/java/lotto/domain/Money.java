package lotto.domain;

public class Money {
    private static final int MIN_POSITIVE_RANGE = 1;
    private static final int SCALE = 1_000;
    private static final int SCALE_STANDARD = 0;

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
        validateScale(amount);
    }

    private void validatePositive(final int amount) {
        if (isNotPositive(amount)) {
            throw new IllegalArgumentException("로또 구입 금액은 양수여야 합니다.");
        }
    }

    private boolean isNotPositive(final int amount) {
        return amount < MIN_POSITIVE_RANGE;
    }

    private void validateScale(final int amount) {
        if (isNotMatchScale(amount)) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private boolean isNotMatchScale(final int amount) {
        return amount % SCALE != SCALE_STANDARD;
    }
}
