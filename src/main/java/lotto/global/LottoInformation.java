package lotto.global;

public enum LottoInformation {
    LOTTO_BALLS_NUMBER(6),
    LOTTO_PRICE_UNIT(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private final int value;

    LottoInformation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
