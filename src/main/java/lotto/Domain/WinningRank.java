package lotto.Domain;

public enum WinningRank {
    ALL(6, 2000000000),
    FIVE_BONUS(5, 30000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000),
    NONE(0, 0);

    private final int matchingCount;
    private final int prize;

    WinningRank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }
}