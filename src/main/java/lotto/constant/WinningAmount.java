package lotto.constant;

public enum WinningAmount {
    ALL_MATCH(6, 2000000000, false),
    FIVE_MATCH_WITH_BONUS(5, 30000000, true),
    FIVE_MATCH(5, 1500000, false),
    FOUR_MATCH(4, 50000, false),
    THREE_MATCH(3, 5000, false),
    NONE_MATCH(0, 0, false);

    private final int matchCount;
    private final int winningAmount;

    private final boolean isBonusNumberMatch;

    WinningAmount(int matchCount, int winningAmount, boolean isBonusNumberMatch) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.isBonusNumberMatch = isBonusNumberMatch;
    }

    public static Integer getWinningAmount(Integer generalNumberMatchCount, Boolean isBonusNumberMatch) {
        for (WinningAmount winningAmount : WinningAmount.values()) {
            if (winningAmount.matchCount == generalNumberMatchCount
                    && winningAmount.isBonusNumberMatch == isBonusNumberMatch) {
                return winningAmount.winningAmount;
            }
        }
        return NONE_MATCH.winningAmount;
    }
}
