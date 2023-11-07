package lotto.constant;

public enum LottoNumber {
    ZERO(0),
    LOTTO_NUMBER_LENGTH(6),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    PURCHASE_UNIT(1000),
    COUNT_UNIT(1),
    PERCENT(100);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
