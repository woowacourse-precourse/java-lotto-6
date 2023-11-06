package lotto;

public enum LottoPrizeRank {
    FIRST(2_000_000_000L, 6, 0),
    SECOND(30_000_000L, 5, 1),
    THIRD(1_500_000L, 5, 0),
    FOURTH(50_000L, 4, 0),
    FIFTH(5_000L, 3, 0);

    private final long winningAmount;
    private final int numNumberMatches;
    private final int numBonusNumberMatches;

    LottoPrizeRank(long winningAmount, int numNumberMatches, int numBonusNumberMatches) {
        this.winningAmount = winningAmount;
        this.numNumberMatches = numNumberMatches;
        this.numBonusNumberMatches = numBonusNumberMatches;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public int getNumNumberMatches() {
        return numNumberMatches;
    }

    public int getNumBonusNumberMatches() {
        return numBonusNumberMatches;
    }
}
