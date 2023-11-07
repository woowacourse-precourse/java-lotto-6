package lotto.constant;

public enum LottoConstant {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    ALLOW_DUPLICATE_NUMBER_COUNT(1),
    LOTTO_SIZE(6),
    MIN_SCORE(0),
    MAX_SCORE(7);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
