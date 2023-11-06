package view;

public enum WinningPrize {
    FIFTH("3", 5000),
    FOURTH("4", 50000),
    THIRD("5", 1500000),
    SECOND("5", 30000000),
    FIRST("6", 2000000000);

    private final String matchCount;
    private final int prizeAmount;

    WinningPrize(String matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public String getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
