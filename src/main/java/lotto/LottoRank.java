package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int reward;
    private final boolean bonusMatch;

    LottoRank(int matchCount, int reward, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonusMatch = bonusMatch;
    }


    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount && (!hasBonus || rank == SECOND)) {
                return rank;
            }
        }
        return NONE;
    }

    public long getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

}
