package lotto.enumration;

public enum Prize {
    FIRST(6, 2000000000, 1),
    SECOND(5, 30000000, 2),
    THIRD(5, 1500000, 3),
    FOURTH(4, 50000, 4),
    FIFTH(3, 5000, 5),
    NONE(0, 0, 0);

    private final int matchCount;
    private final int winningMoney;
    private final int rank;

    Prize(int matchCount, int winningMoney, int rank) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.rank = rank;
    }

    public static Prize of(int matchCount, boolean matchBonus) {

        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }

        if (matchCount == 5) {
            return THIRD;
        }

        if (matchCount == 4) {
            return FOURTH;
        }

        if (matchCount == 3) {
            return FIFTH;
        }

        if (matchCount == 6) {
            return FIRST;
        }

        return NONE;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRank() {
        return rank;
    }
}
