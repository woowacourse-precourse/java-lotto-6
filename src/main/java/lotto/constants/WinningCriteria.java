package lotto.constants;

public enum WinningCriteria {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false),
    LOSE(0, 0, false);

    private final int matchingCount;
    private final int prizeAmount;
    private final boolean isBonus;

    WinningCriteria(int matchingCount, int prizeAmount, boolean isBonus) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.isBonus = isBonus;
    }

    public static WinningCriteria getRating(final int matchCount, final boolean isBonus) {
        for (WinningCriteria winningCriteria : WinningCriteria.values()) {
            if (matchCount == winningCriteria.matchingCount && isBonus == winningCriteria.isBonus) {
                return winningCriteria;
            }
        }
        return LOSE;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
