package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(4, 1_500_000),
    FOURTH(3, 50_000),
    FIFTH(2, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchCount && (!bonusMatch || rank == SECOND)) {
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
}
