package lotto.config;

public enum LottoConstants {
    LOTTO_SIZE(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
