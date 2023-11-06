package lotto;

public enum LottoConstant {

    MIN_AMOUNT_OF_LOTTO(1_000),
    MAX_AMOUNT_OF_LOTTO(100_000),

    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),

    LOTTO_NUMBER_SIZE(6);



    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
