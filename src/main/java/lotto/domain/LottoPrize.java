package lotto.domain;

public enum LottoPrize {

    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prize;
    LottoPrize(int matchCount, int prize) {
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