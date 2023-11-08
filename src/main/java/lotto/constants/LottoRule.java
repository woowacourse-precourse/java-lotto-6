package lotto.constants;

public enum LottoRule {
    MIN_LOTTO_NUM(1),
    MAX_LOTTO_NUM(45),
    LOTTO_MAX_SIZE(6),
    MIN_PRICE(0),
    MAX_PRICE(100_000),
    UNIT_PRICE(1000);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
