package lotto;

public enum Prize {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    NONE(0, 0, false, 0);

    Prize(int rank, int matchedCount, boolean isBonusMatched, int prizeMoney) {
        this.rank = rank;
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeMoney = prizeMoney;
    }

    public final int rank;
    public final int matchedCount;
    public final boolean isBonusMatched;
    public final int prizeMoney;

    public static Prize getPrize(int matchCount) {
        for (Prize prize : Prize.values()) {
            if (prize.matchedCount == matchCount) {
                return prize;
            }
        }
        return NONE;
    }
}
