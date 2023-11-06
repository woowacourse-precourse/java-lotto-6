package lotto.model;

public enum Rank {
    FIRST(6, true, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchingNumbers;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(int matchingNumbers, boolean hasBonusNumber, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int calculatePrize() {
        return prize;
    }

    public static Rank calculateRank(int matchingNumbers, boolean hasBonusNumber) {
        for (Rank rank : values()) {
            if (rank.matchingNumbers == matchingNumbers && rank.hasBonusNumber == hasBonusNumber) {
                return rank;
            }
        }
        return NONE;
    }
}
