package lotto.constants;

public enum ConstantValues {
    START_LOTTO_NUMBER(1),
    END_LOTTO_NUMBER(45),
    LOTTO_LENGTH(6),
    LOTTO_COST(1000),
    FIVE_PRIZE(5000),
    FOUR_PRIZE(50000),
    THREE_PRIZE(1500000),
    TWO_PRIZE(30000000),
    ONE_PRIZE(2000000000);

    private final int value;

    ConstantValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
