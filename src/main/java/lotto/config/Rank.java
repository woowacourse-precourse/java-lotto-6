package lotto.config;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeMoney;

    Rank(int matchCount, boolean bonusMatch, int prizeMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(long matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && (!rank.bonusMatch || bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeMoneyFormatted() {
        return String.format("%,d", getPrizeMoney());
    }
    
}
