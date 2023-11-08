package lotto.model;

public enum LottoRank {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true), // 5개 매치 + 보너스 볼
    FIRST(6, 2_000_000_000, false);

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

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == SECOND.matchCount && bonusMatch) {
            return SECOND;
        }

        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchCount && !rank.bonusMatch) {
                return rank;
            }
        }

        return MISS;
    }


}
