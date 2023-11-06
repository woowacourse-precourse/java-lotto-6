package lotto.global.constant;

import java.util.Arrays;

public enum WinningType {

    OTHER(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean isBonusMatch;
    private final long revenue;

    WinningType(final int matchCount, final boolean isBonusMatch, long revenue) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.revenue = revenue;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getRevenue() {
        return revenue;
    }

    public static WinningType findByCondition(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(WinningType.values())
                .filter(winningType -> winningType.matchCount == matchCount && winningType.isBonusMatch == isBonusMatch)
                .findFirst()
                .orElse(WinningType.OTHER);
    }
}
