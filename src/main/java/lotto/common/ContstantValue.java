package lotto.common;

public enum ContstantValue {
    LOTTO_UNIT_PRICE(1000),
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    LOTTO_UNIT_SIZE(6)
    ;

    private int value;

    public int getValue() {
        return value;
    }

    ContstantValue(int value) {
        this.value = value;
    }
}
