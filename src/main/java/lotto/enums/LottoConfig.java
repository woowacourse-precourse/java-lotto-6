package lotto.enums;

public enum LottoConfig {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1_000);

    private final int value;

    LottoConfig(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
