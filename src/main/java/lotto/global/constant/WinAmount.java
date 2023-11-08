package lotto.global.constant;

public enum WinAmount {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    FIFTH_WITH_BONUS(51, 30000000),
    SIXTH(6, 2000000000);

    private final long matchCount;
    private final long amount;

    WinAmount(long matchCount, long amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public long getMatchCount() {
        return this.matchCount;
    }

    public static long findWinAmount(long matchCount) {
        for (WinAmount item : WinAmount.values()) {
            if (item.matchCount == matchCount) {
                return item.amount;
            }
        }
        return 0;
    }
}