package lotto.constant;

public enum LottoRank {
    FIRST(6, "NoBonus"),
    SECOND(5, "Bonus"),
    THIRD(5, "NoBonus"),
    FORTH(4, "NoBonus"),
    FIFTH(3, "NoBonus");

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
