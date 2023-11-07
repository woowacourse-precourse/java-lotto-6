package lotto.domain;

public enum WinningDetails {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_WITH_BONUS_MATCH(5, true, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean isBonusMatched;

    WinningDetails(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonusMatched = false;
    }

    WinningDetails(int matchCount, boolean isBonusMatched, int prizeMoney) {
        this.matchCount = matchCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeMoney = prizeMoney;
    }

    public static WinningDetails calculateResult(int countMatchedNum, boolean isMatchedBonus) {
        for (WinningDetails winningDetails : WinningDetails.values()) {
            if (winningDetails.matchCount == countMatchedNum && winningDetails.isBonusMatched == isMatchedBonus) {
                return winningDetails;
            }
        }
        return null;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
