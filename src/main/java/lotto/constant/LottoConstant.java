package lotto.constant;

public enum LottoConstant {
    MIN_LOTTO_NUMBER_BOUND(1),
    MAX_LOTTO_NUMBER_BOUND(45),
    LOTTO_AMOUNT_UNIT(1000),
    VALID_LOTTO_NUMBER_NUM(6);

    private int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
