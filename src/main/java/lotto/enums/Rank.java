package lotto.enums;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISSING(0, 0, false);
    private final int countOfMatch;
    private final int winningMoney;

    private final boolean hasBonusNumber;

    private Rank(int countOfMatch, int winningMoney, boolean hasBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank calculateRank(int countOfMatch, boolean hasBonusNumber) {
        Rank foundRank = MISSING;
        for (Rank rank : Rank.values()) {
            if (rank.countOfMatch == countOfMatch && rank.hasBonusNumber == hasBonusNumber) {
                foundRank = rank;
            }
        }
        return foundRank;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
