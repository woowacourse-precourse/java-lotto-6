package lotto.model;

public enum Winning {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    LOSE(0, false, 0);

    private static final Winning[] ENUMS = Winning.values();
    private static final int rankCount = 6;
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

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean isBonusNumberMatch() {
        return isBonusNumberMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public Winning plus(long ranks) {
        int amount;
        amount = (int) (ranks % rankCount);
        return ENUMS[(ordinal() + (amount + rankCount)) % rankCount];
    }

    public Winning minus(long ranks) {
        return plus(-(ranks % rankCount));
    }
}
