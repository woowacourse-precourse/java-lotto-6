package lotto.constant;

public enum Rank {
    ELSE(0,0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    SECOND_WITH_BONUS(7, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}

