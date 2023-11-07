package lotto.constants;

public enum LottoConfig {
    NUMBER_LENGTH(6),
    RANDOM_RANGE_MIN_NUMBER(1),
    RANDOM_RANGE_MAX_NUMBER(45),
    UNIT_PRICE(1_000);

    private final int value;
    LottoConfig (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
