package lotto.enums;

public enum PrizeRank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCondition;
    private final int prize;

    PrizeRank(int matchCondition, int prize) {
        this.matchCondition = matchCondition;
        this.prize = prize;
    }

    public int matchCondition() {
        return matchCondition;
    }

    public int prize() {
        return prize;
    }
}
