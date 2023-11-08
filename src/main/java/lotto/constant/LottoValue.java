package lotto.constant;

public enum LottoValue {
    AMOUNT_UNIT(1000),
    MIN_RANGE(1),
    MAX_RANGE(45),
    NUMBERS_COUNT(6);

    private int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
