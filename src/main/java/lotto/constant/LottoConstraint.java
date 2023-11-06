package lotto.constant;

public enum LottoConstraint {
    PRICE_PER_LOTTO(1000),
    MIN_PURCHASE_QUANTITY(1),
    MAX_PURCHASE_QUANTITY(1000000),
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ;

    private final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
