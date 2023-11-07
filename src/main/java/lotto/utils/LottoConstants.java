package lotto.utils;

public enum LottoConstants {
    LOTTO_SIZE(6),
    NUMBER_MAX_SIZE(45),
    NUMBER_MIN_SIZE(1);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
