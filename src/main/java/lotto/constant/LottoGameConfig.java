package lotto.constant;

public enum LottoGameConfig {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    AMOUNT_OF_NUMBERS(6);

    private final int value;

    LottoGameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
