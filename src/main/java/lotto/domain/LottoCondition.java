package lotto.domain;

public enum LottoCondition {

    START_NUMBER(1),
    END_NUMBER(45),
    COUNT(6),
    PURCHASE_PRICE(1000);

    private final int value;

    LottoCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
