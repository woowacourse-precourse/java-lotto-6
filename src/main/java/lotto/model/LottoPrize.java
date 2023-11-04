package lotto.model;

public enum LottoPrize {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_AND_BONUS_MATCH(-1, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final long prize;

    LottoPrize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}