package lotto;

public enum Ranking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchingCount;
    private final boolean shouldMatchingBonusNumber;
    private final int prizeMoney;

    Ranking(final int matchingCount, final boolean shouldMatchingBonusNumber, final int prizeMoney) {
        this.matchingCount = matchingCount;
        this.shouldMatchingBonusNumber = shouldMatchingBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public static Ranking find(int count, boolean hasBonusNumber) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.isEqual(count, hasBonusNumber))
                return ranking;
        }
        return Ranking.NONE;
    }

    private boolean isEqual(int count, boolean hasBonusNumber) {
        if (count == 5)
            return this.matchingCount == count && this.shouldMatchingBonusNumber == hasBonusNumber;
        return this.matchingCount == count;
    }
}
