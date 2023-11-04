package lotto.util;

public enum LottoConstant {

    LOTTO_START_NUMBER(1) ,
    LOTTO_MAX_NUMBER(45),
    LOTTO_BONUS_NUMBER_COUNT(1),
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_COUNT(6);

    private int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
