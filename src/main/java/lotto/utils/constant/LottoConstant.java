package lotto.utils.constant;

public enum LottoConstant {

    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_MONEY_MIN(0),
    LOTTO_MONEY_MAX(100000),
    LOTTO_MONEY_UNIT(1000),
    ;

    private final int value;

    LottoConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
