package lotto.utils;

public enum Prize {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NO_PRIZE(2);

    private final int sameCount;

    Prize(int sameCount) {
        this.sameCount = sameCount;
    }

    public int getSameCount() {
        return sameCount;
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