package lotto.global.utils.constant;

public enum LottoNumberType {

    MAX_NUMBER_OF_RANGE(45),
    MIN_NUMBER_OF_RANGE(1),
    LENGTH_OF_LOTTO(6),
    LOTTO_AMOUNT_UNIT(1000);

    private final int value;

    LottoNumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
