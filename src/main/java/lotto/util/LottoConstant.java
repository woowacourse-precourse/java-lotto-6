package lotto.util;

public enum LottoConstant {

    LOTTO_START_NUMBER(1) ,
    LOTTO_MAX_NUMBER(45),
    LOTTO_BONUS_NUMBER_COUNT(1),
    LOTTO_PRICE(1000),
    LOTTO_1ST_PRICE(2_000_000_000),
    LOTTO_2ST_PRICE(30_000_000),
    LOTTO_3ST_PRICE(1_500_000),
    LOTTO_4ST_PRICE(50_000),
    LOTTO_5ST_PRICE(5_000),

    LOTTO_NUMBER_COUNT(6);

    private int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
