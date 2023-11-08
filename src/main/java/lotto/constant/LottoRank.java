package lotto.constant;

public enum LottoRank {
    FIFTH(3, "NoBonus"),
    FORTH(4, "NoBonus"),
    THIRD(5, "NoBonus"),
    SECOND(5, "Bonus"),
    FIRST(6, "NoBonus");

    private final int winningCount;
    private final String bonus;

    LottoRank(int winningCount, String bonus) {
        this.winningCount = winningCount;
        this.bonus = bonus;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public String getBonus() {
        return bonus;
    }
}
