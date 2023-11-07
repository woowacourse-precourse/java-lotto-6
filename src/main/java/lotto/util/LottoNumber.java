package lotto.util;

public enum LottoNumber {
    PURCHASE_MIN_PRICE(1000),
    START_LOTTO_NUMBER(1),
    END_LOTTO_NUMBER(45),
    LOTTO_SIZE(6),
    LOTTO_SAME_NUMBER_TWO(2),
    LOTTO_SAME_NUMBER_FIVE(5),
    LOTTO_SAME_NUMBER_FIVE_WITH_BONUS_KEY(7);

    int value;

    LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
