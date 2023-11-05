package lotto.common.constants;

public enum LottoRule {
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_SIZE(6),
    LOTTO_PURCHASE_AMOUNT_UNIT(1_000),
    LOTTO_PURCHASE_AMOUNT_MIN(1_000),
    LOTTO_PURCHASE_AMOUNT_MAX(100_000_000);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
