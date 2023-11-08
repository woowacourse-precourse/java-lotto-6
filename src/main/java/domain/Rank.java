package domain;

public enum Rank {
    ZERO_MATCH(0, 0L),
    ONE_MATCH(0, 0L),
    TWO_MATCH(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L)
    ;

    final private int match;
    final private long prize;

    Rank(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }
}
