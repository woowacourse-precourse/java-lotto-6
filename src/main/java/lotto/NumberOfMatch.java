package lotto;

public enum NumberOfMatch {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_PLUS(5, 30000000),
    SIX(6, 2000000000);
    private final int matchCount;
    private final int winningPrice;

    NumberOfMatch(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
