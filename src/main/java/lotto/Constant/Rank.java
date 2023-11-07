package lotto.Constant;

public enum Rank {
    FAIL(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int winningMoney;
    private final boolean matchBonus;

    Rank(int matchCount, int winningMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (matchCount == rank.matchCount && rank == THIRD && matchBonus) {
                return SECOND;
            }
            if (matchCount == rank.matchCount && rank != SECOND) {
                return rank;
            }
        }
        return FAIL;
    }
}
