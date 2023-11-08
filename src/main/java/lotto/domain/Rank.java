package lotto.domain;

public enum Rank {
    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;

    Rank(int matchCount, int prizeMoney, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matches(matchCount, bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }

    public boolean matches(int count, boolean bonus) {
        if (this.matchCount != count) {
            return false;
        }
        return this.bonusMatch == bonus;
    }


    public int getMatchCount() {
        return matchCount;
    }
    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
