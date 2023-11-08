package lotto.configuration;

public enum IntegerConstants {
    COST_OF_LOTTO(1000),
    MAX_NUMBER_COUNT_OF_LOTTO(6),
    MIN_NUMBER_RANGE(1),
    MAX_NUMBER_RANGE(45);

    private final int value;

    IntegerConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
