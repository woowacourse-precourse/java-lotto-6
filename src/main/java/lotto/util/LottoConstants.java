package lotto.util;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    NUMBER_OF_LOTTO_NUMBERS(6),
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
