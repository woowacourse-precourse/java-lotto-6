package lotto.enums;

public enum LottoNumberRange {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    MIN_PAYMENT_AMOUNT(1000),
    MIN_SELECT_COUNT(6);

    private final int value;

    LottoNumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
