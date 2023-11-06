package lotto.constant;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    OUT_OF_RANK(0, false, 0)
    ;

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    LottoRank(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank getLottoMatchByCount(int matchCount, boolean hasBonus) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount && rank.isHasBonus() == hasBonus) {
                return rank;
            }
        }
        return LottoRank.OUT_OF_RANK;
    }
}
