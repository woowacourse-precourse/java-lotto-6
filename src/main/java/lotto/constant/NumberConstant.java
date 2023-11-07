package lotto.constant;

public enum NumberConstant {
    START_NUMBER(1),
    END_NUMBER(45),
    COUNT(6),
    LOTTO_PRICE(1_000);

    private final int value;

    NumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
