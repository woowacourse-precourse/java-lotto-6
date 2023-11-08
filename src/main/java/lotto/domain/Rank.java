package lotto.domain;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean matchBonus;

    Rank(int matchCount, int prizeMoney) {
        this(matchCount, prizeMoney, false);
    }

    Rank(int matchCount, int prizeMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static Rank calculateRank(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }

        for (Rank rank : Rank.values()) {
            if (matchCount == rank.getMatchCount() && (matchBonus == rank.isMatchBonus())) {
                return rank;
            }
        }

        return MISS;
    }
}