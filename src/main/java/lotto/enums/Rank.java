package lotto.enums;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean containBonus;
    private final int winningAmount;

    Rank(int matchCount, boolean containBonus, int winningAmount) {
        this.matchCount = matchCount;
        this.containBonus = containBonus;
        this.winningAmount = winningAmount;
    }

    public int getMatchedCount() {
        return this.matchCount;
    }

    public boolean containsBonus() {
        return this.containBonus;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }
}
