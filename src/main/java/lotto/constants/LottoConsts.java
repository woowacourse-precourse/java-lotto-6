package lotto.constants;

public enum LottoConsts {
    LOTTO_NUMBERS_SIZE(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_PRICE(1000),
    ;
    private final int value;

    LottoConsts(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
