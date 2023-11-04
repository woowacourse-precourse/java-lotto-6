package lotto.utils;

public enum LottoConstants {
    LOTTO_PRICE(1_000),
    LOTTO_NUM_SIZE(6),
    LOTTO_NUM_MIN(1),
    LOTTO_NUM_MAX(45);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
