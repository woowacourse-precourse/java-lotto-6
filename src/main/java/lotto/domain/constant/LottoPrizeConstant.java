package lotto.domain.constant;

public enum LottoPrizeConstant {

    FIRST_PRIZE_COUNT(6),
    SECOND_PRIZE_COUNT(5),
    THIRD_PRIZE_COUNT(5),
    FOURTH_PRIZE_COUNT(4),
    FIFTH_PRIZE_COUNT(3);

    private final int number;

    LottoPrizeConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
