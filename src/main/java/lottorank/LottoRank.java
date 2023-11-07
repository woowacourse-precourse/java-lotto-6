package lottorank;

public enum LottoRank {
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_PLUS_BONUS_MATCH(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;

    LottoRank(int matchCount, int prizeMoney, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
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

    public static LottoRank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_PLUS_BONUS_MATCH;
        }
        for (LottoRank rank : values()) {
            if (rank.getMatchCount() == matchCount && !rank.isBonusMatch()) {
                return rank;
            }
        }
        return null;
    }

}


