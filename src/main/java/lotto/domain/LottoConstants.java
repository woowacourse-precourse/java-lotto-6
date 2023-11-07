package lotto.domain;

public enum LottoConstants {
    LOTTO_NUMBER_RANGE_START(1),
    LOTTO_NUMBER_RANGE_END(45),
    LOTTO_PRICE(1000),
    LOTTO_LENGTH_CONSTRAINT(6),
    MIN_LOTTO_BUY_QUANTITY(1);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
