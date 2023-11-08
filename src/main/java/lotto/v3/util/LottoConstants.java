package lotto.v3.util;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    MAX_RETRY_ATTEMPTS(10),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBERS_SIZE(6);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
