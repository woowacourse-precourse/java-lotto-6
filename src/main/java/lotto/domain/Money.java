package lotto.domain;

public class Money {
    public static final Long MIN_RANGE = 1_000L;
    public static final Long MAX_RANGE = 100_000_000_000L;
    public static final Long UNIT = 1_000L;
    private final Long value;

    public Money(Long value) {
        validateRange(value);
        validateUnit(value);
        this.value = value;
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
