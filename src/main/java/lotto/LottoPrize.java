package lotto;

public enum LottoPrize {
    FIRST_PRIZE(2_000_000_000L, 6, 0),
    SECOND_PRIZE(30_000_000L, 5, 1),
    THIRD_PRIZE(1_500_000L, 5, 0),
    FOURTH_PRIZE(50_000L, 4, 0),
    FIFTH_PRIZE(5_000L, 3, 0);

    private final long winningAmount;
    private final int numNumberMatches;
    private final int numBonusNumberMatches;

    LottoPrize(long winningAmount, int numNumberMatches, int numBonusNumberMatches) {
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
