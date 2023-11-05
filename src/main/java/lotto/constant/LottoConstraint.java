package lotto.constant;

public enum LottoConstraint {
    PRICE_PER_LOTTO(1000),
    MIN_PURCHASE_QUANTITY(1),
    MAX_PURCHASE_QUANTITY(1000000),
    MIN_AMOUNT(PRICE_PER_LOTTO.getValue() * MIN_PURCHASE_QUANTITY.getValue()),
    MAX_AMOUNT(PRICE_PER_LOTTO.getValue() * MAX_PURCHASE_QUANTITY.getValue()),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ;

    public final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
