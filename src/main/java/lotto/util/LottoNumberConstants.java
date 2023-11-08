package lotto.util;

public enum LottoNumberConstants {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_PRICE(1000),
    NO_REMAINDER(0),
    NUMBER_OF_LOTTO_NUMBERS(6),
    ONE_HUNDRED_PERCENT(100);
    private final int value;

    LottoNumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
