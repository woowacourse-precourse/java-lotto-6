package lotto.domain;

public enum LottoRank {
    NONE(0, false),
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false);

    private final int matchCount;
    private final boolean bonusMatch;

    LottoRank(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public static LottoChecker.LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoChecker.LottoRank rank : LottoChecker.LottoRank.values()) {
            if (rank.matchCount == matchCount && (!bonusMatch || rank.bonusMatch == bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }
}
