package lotto;

public enum Rank {
    FAIL(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, long prize) {
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