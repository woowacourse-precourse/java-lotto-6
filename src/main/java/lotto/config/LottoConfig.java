package lotto.config;

public enum LottoConfig {
    PURCHASE_AMOUNT_MAX(100000),
    PURCHASE_DIVISIBLE_AMOUNT(1000),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_AMOUNT_MAX(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
