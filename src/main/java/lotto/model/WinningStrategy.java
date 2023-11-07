package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum WinningStrategy {
    MATCHES_THREE(3, false,5000),
    MATCHES_FOUR(4, false,50000),
    MATCHES_FIVE(5, false,1500000),
    MATCHES_FIVE_WITH_BONUS(5, true,30000000),
    MATCHES_SIX(6, false,2000000000);

    private int matchCount;
    private boolean bonusMatch;
    private int winningAmount;

    WinningStrategy(int matchCount, boolean bonusMatch, int winningAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winningAmount = winningAmount;
    }

    public static Optional<WinningStrategy> find(int matchCount, boolean bonusMatch) {
        return Arrays.stream(WinningStrategy.values())
                .filter(winningStrategy -> winningStrategy.matchCount == matchCount && winningStrategy.bonusMatch == bonusMatch)
                .findFirst();
    }
}
