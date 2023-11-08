package lotto;

public enum LottoConst {
    MIN_RANGE_NUMBER(1),
    MAX_RANGE_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);
    private final int value;

    LottoConst(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
