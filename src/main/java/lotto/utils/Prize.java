package lotto.utils;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NO_PRIZE(2, 0);

    private final int sameCount;
    private final int prizeProfit;

    Prize(int sameCount, int prizeProfit) {
        this.sameCount = sameCount;
        this.prizeProfit = prizeProfit;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getPrizeProfit() {
        return prizeProfit;
    }

    public static Prize getPrizeRank(int sameCount, boolean hasBonusNumber) {
        if (SECOND.getSameCount() == sameCount) {
            return distinguishSecondOrThird(hasBonusNumber);
        }
        for (Prize prize : values()) {
            if (prize.getSameCount() == sameCount) {
                return prize;
            }
        }
        return NO_PRIZE;
    }

    private static Prize distinguishSecondOrThird(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }
}