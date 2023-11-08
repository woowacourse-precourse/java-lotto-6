package lotto.constant;

public enum IntConstants {
    PURCHASE_AMOUNT_UNIT(1000),
    LOTTO_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    SPECIAL_MATCH_COUNT(5);

    private final int value;

    IntConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
