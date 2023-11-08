package lotto.service;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final long prize;

    LottoRank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonusMatched) {
        if (matchCount == SECOND.matchCount && hasBonusMatched) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return NONE;
    }

    public long getPrize() {
        return prize;
    }
}
