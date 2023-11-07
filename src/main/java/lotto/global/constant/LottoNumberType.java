package lotto.global.constant;

public enum LottoNumberType {

    MIN_RANGE_OF_LOTTO(1),
    MAX_RANGE_OF_LOTTO(45),
    LENGTH_OF_LOTTO(6),
    LOTTO_AMOUNT_UNIT(1000);

    private final int value;

    LottoNumberType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
