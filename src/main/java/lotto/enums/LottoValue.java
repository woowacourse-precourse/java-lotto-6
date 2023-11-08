package lotto.enums;

public enum LottoValue {
    MIN_LOTTO_NUMBER_RANGE(1),
    MAX_LOTTO_NUMBER_RANGE(45),
    NUMBER_COUNT(6),
    PRICE_PER_LOTTO(1000),
    PURCHASE_LIMIT_PRICE(100_000),
    FIVE_MATCH(5);

    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
