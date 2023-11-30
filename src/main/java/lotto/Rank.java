package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int countOfMatch;
    private final int winningAmount;
    private final boolean bonusMatch;

    Rank(int countOfMatch, int winningAmount, boolean bonusMatch) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
        this.bonusMatch = bonusMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static Rank valueOf(int countOfMatch, boolean bonusMatch) {
        if (countOfMatch == 6) {
            return FIRST;
        }
        if (countOfMatch == 5 && bonusMatch) {
            return SECOND;
        }
        for (Rank rank : Rank.values()) {
            if (countOfMatch == rank.countOfMatch && bonusMatch == rank.bonusMatch) {
                return rank;
            }
        }
        return MISS;
    }
}
