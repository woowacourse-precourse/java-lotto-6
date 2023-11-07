package lotto.constant;

public enum LotteryRank {
    FIRST_PRIZE(1),
    SECOND_PRIZE(2),
    THIRD_PRIZE(3),
    FOURTH_PRIZE(4),
    FIFTH_PRIZE(5);

    private final int rank;

    private LotteryRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
