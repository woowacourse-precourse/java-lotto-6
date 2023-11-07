package lotto.constant;

public enum LottoNumber {

    LOTTO_SIZE(6),
    LOTTO_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    DEFAULT_MAX_AMOUNT_OF_LOTTO(Integer.MAX_VALUE),

    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FORTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    private int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
