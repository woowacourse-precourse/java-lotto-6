package lotto.common;

public enum Constraint {

    LOTTO_MAX_SIZE(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    PURCHASE_AMOUNT_UNIT(1000)
    ;

    private final int value;

    Constraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
