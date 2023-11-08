package lotto.domain;

public enum LottoPrize {
    NOTHING(0, 0, false),
    FIFTH(3, 5000, false),
    FORTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int matchedCount;
    private final int prizeMoney;
    private final boolean hasBonusNumber;

    LottoPrize(int matchedCount, int prizeMoney, boolean hasBonusNumber) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoPrize getPrize(final int matchedCount, final boolean containsBonusNumber) {
        for (LottoPrize prize : values()) {
            if (prize.matchedCount == matchedCount && prize.hasBonusNumber == false) {
                return prize;
            }
            if (prize.matchedCount == matchedCount && prize.hasBonusNumber == true) {
                return SECOND;
            }
        }
        return NOTHING;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
