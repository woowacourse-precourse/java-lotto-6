package lotto.constants;

import java.util.Arrays;

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

    public static WinningCriteria getRating(final int matchingCount, final boolean isBonus) {
        return Arrays.stream(WinningCriteria.values())
                .filter(winningCriteria -> matchingCount == winningCriteria.matchingCount
                        && isBonus == winningCriteria.isBonus)
                .findFirst()
                .orElse(LOSE);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
