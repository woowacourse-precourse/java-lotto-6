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
}
