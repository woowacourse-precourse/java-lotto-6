package domain;

public enum Rank {
    ZERO_MATCH(0, 0L, "0"),
    ONE_MATCH(0, 0L, "0"),
    TWO_MATCH(0, 0L, "0"),
    FIFTH(3, 5_000L, "5,000"),
    FOURTH(4, 50_000L, "50,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    FIRST(6, 2_000_000_000L, "2,000,000,000"),
    SECOND(5, 30_000_000L, "30,000,000")
    ;

    final private int match;
    final private long prize;
    final private String stringPrize;

    Rank(int match, long prize, String stringPrize) {
        this.match = match;
        this.prize = prize;
        this.stringPrize = stringPrize;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }

    public String getStringPrize() {
        return stringPrize;
    }
}
