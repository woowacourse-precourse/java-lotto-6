package lotto.constant;

public enum LotteryRankConstant {
    FIRST_RANK(2000000000),
    SECOND_RANK(30000000),
    THIRD_RANK(1500000),
    FOURTH_RANK(50000),
    FIFTH_RANK(5000),
    NONE(0);

    private final long prizeMoney;

    LotteryRankConstant(final long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }
}
