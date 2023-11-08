package lotto.domain;

public record Money(Long value) {
    private static final Long MIN_RANGE = 1_000L;
    private static final Long MAX_RANGE = 100_000_000_000L;
    private static final Long UNIT = 1_000L;

    public Money {
        validateRange(value);
        validateUnit(value);
    }

    private void validateRange(Long value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(Long value) {
        if (value % UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
}
