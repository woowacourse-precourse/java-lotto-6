package lotto.constant;

public enum DomainConstant {
    START_INDEX(0),
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_BONUS_SIZE(7);
    private final int value;

    DomainConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
