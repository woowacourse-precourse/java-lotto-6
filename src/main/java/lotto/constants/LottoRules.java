package lotto.constants;

public enum LottoRules {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    BONUS_NUMBER_COUNT(1),
    LOTTO_PRICE(1_000),
    PURCHASE_AMOUNT_MIN(1_000),
    PURCHASE_AMOUNT_MAX(100_000);

    private final int value;

    LottoRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
