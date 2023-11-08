package lotto.constant;

public enum LottoRank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    private final int prizeMoney;
    private final int matchCount;

    LottoRank(int prizeMoney, int matchCount) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank selectRankByMatchCount(int matchCount, boolean bonusNumberHit) {
        if (matchCount == FIRST.getMatchCount()) {
            return FIRST;
        }
        if (matchCount == SECOND.getMatchCount() && bonusNumberHit) {
            return SECOND;
        }
        if (matchCount == THIRD.getMatchCount()) {
            return THIRD;
        }
        if (matchCount == FOURTH.getMatchCount()) {
            return FOURTH;
        }
        if (matchCount == FIFTH.getMatchCount()) {
            return FIFTH;
        }
        return NONE;
    }
}
