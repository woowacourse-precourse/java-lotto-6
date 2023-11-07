package lotto.config;

public enum LottoGameRule {
    LOTTO_SIZE(6),
    LOTTO_MIN_VALUE(1),
    LOTTO_MAX_VALUE(45),
    LOTTO_PRICE(1000),
    PURCHASE_AMOUNT_UNIT(1000),
    ;

    private final int value;

    LottoGameRule(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
