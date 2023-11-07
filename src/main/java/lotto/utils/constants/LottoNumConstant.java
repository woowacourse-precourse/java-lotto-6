package lotto.utils.constants;

public enum LottoNumConstant {
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    LOTTO_SIZE(6),
    LOTTO_AMOUNT_PURCHASE(1000),
    ZERO(0),
    LOTTO_FIFTH_PRIZE(5000),
    LOTTO_FOURTH_PRIZE(50000),
    LOTTO_THIRD_PRIZE(1500000),
    LOTTO_SECOND_PRIZE(30000000),
    LOTTO_FIRST_PRIZE(2000000000),
    LOTTO_THREE_COUNT(3),
    LOTTO_FOUR_COUNT(4),
    LOTTO_FIVE_COUNT(5),
    LOTTO_SIX_COUNT(6);


    private final int number;

    LottoNumConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
