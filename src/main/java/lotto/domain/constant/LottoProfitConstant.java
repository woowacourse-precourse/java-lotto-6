package lotto.domain.constant;

public enum LottoProfitConstant {

    FIFTH_PRIZE_AMOUNT(5000),
    FOURTH_PRIZE_AMOUNT(50000),
    THIRD_PRIZE_AMOUNT(1500000),
    SECOND_PRIZE_AMOUNT(30000000),
    FIRST_PRIZE_AMOUNT(2000000000),
    LOTTO_PRICE(1000);

    private final int number;

    LottoProfitConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
