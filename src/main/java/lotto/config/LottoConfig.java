package lotto.config;

public enum LottoConfig {
    PRICE_PER_TICKET(1000),
    LOTTO_NUMBERS_SIZE(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

