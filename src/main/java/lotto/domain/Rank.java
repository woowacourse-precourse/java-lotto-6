package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(-1, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    Rank(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static int findPrizeMoney(Rank rank) {
        return rank.prizeMoney;
    }

    public static Rank findRank(int count, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == count) {
                return determineSecondOrThirdRank(rank, hasBonus);
            }
        }
        return Rank.NOTHING;
    }

    private static Rank determineSecondOrThirdRank(Rank rank, boolean hasBonus) {
        if (rank.matchCount == Rank.SECOND.matchCount) {
            if (hasBonus == Rank.SECOND.matchBonus) {
                return Rank.SECOND;
            } else if (hasBonus == Rank.THIRD.matchBonus) {
                return Rank.THIRD;
            }
        }
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

}
