package lotto.enums;

public enum LottoRank {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000),
    NO_PRIZE(0);

    private final int prizeAmount;

    LottoRank(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}