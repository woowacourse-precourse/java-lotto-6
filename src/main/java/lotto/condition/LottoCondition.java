package lotto.condition;

public enum LottoCondition {
    LOTTO_PRICE(1000),
    LOTTO_COUNT(6),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45)
    ;

    private final int value;

    LottoCondition(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
