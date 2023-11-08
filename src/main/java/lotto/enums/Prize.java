package lotto.enums;

import java.util.Arrays;

public enum Prize {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    public static final Prize[] PRIZES = values();
    private final int matchedCount;
    private final int winningAmount;

    Prize(final int matchedCount, final int winningAmount) {
        this.matchedCount = matchedCount;
        this.winningAmount = winningAmount;
    }

    public static Prize valueOf(final int matchedCount, final boolean isBonus) {
        if (matchedCount == SECOND.matchedCount && isBonus) {
            return SECOND;
        }

        return Arrays.stream(PRIZES)
                .filter(p -> p.matchedCount == matchedCount)
                .filter(p -> p != SECOND)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }
}
