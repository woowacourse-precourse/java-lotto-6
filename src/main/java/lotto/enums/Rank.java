package lotto.enums;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISSING(0, 0);
    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank calculateRank(int countOfMatch, boolean hasBonusNumber) {
        Rank foundRank = MISSING;
        for (Rank rank : Rank.values()) {
            if (rank.countOfMatch == countOfMatch) {
                foundRank = rank;
            }
            if (hasBonusNumber && rank == THIRD) {
                foundRank = SECOND;
            }
        }
        return foundRank;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
