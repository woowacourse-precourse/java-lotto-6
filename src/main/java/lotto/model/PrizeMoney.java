package lotto.model;

public enum PrizeMoney {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(7, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000);

    private final int matchNum;

    private final int prizeMoney;

    PrizeMoney(int matchNum, int prizeMoney) {
        this.matchNum = matchNum;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchNum() {
        return matchNum;
    }
}
