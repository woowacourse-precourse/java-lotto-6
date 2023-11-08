package lotto;

public enum Rank {
    FIRST(6, "2,000,000,000", 2000000000),
    SECOND(5.5, "30,000,000", 30000000),
    THIRD(5, "1,500,000", 1500000),
    FOURTH(4, "50,000", 50000),
    FIFTH(3, "5,000", 5000),
    MISS(0, "0", 0);

    private final double matchCount;
    private final String prizeMoneyString;

    private final long prizeMoney;

    Rank(double matchCount, String prizeMoneyString, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoneyString = prizeMoneyString;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(double matchCount) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return MISS;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
    public double getMatchCount() {
        return matchCount;
    }

    public String getPrizeMoneyString() {
        return prizeMoneyString;
    }
}
