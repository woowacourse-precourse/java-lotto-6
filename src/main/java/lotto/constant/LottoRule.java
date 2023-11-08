package lotto.constant;

public enum LottoRule {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6),
    MIN_AMOUNT(1000),
    MAX_AMOUNT(100000),
    PRICE(1000);

    private int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
