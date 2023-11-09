package lotto.config;

public enum LottoConfig {
    PURCHASE_AMOUNT_VALUE_MIN(1000),
    PURCHASE_AMOUNT_VALUE_MAX(100000),
    LOTTO_VALUE_MIN(1),
    LOTTO_VALUE_MAX(45),
    LOTTO_VALUE_SIZE(6),
    ZERO(0),
    ONE(1);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
