package lotto.model;

public enum Winning {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    LOSE(0, false, 0);

    private final int matchingNumbers;
    private final boolean isBonusNumberMatch;
    private final int winningAmount;

    Winning(int matchingNumbers, boolean isBonusNumberMatch, int winningAmount) {
        this.matchingNumbers = matchingNumbers;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.winningAmount = winningAmount;
    }

    public int getValue() {
        return ordinal();
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
