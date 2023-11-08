package lotto.util;

public enum Prize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_WITH_BONUS(7, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prizeAmount;

    Prize(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
