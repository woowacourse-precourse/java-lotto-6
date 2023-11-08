package lotto.utils.constants;

public enum LottoNumConstant {
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    LOTTO_SIZE(6),
    LOTTO_AMOUNT_PURCHASE(1_000),
    ZERO(0),
    LOTTO_FIFTH_PRIZE(5_000),
    LOTTO_FOURTH_PRIZE(50_000),
    LOTTO_THIRD_PRIZE(1_500_000),
    LOTTO_SECOND_PRIZE(30_000_000),
    LOTTO_FIRST_PRIZE(2_000_000_000),
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
