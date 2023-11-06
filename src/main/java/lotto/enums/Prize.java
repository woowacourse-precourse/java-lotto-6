package lotto.enums;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final Prize[] PRIZES = values();
    private final int matchedCount;
    private final int winningMoney;

    Prize(final int matchedCount, final int winningMoney) {
        this.matchedCount = matchedCount;
        this.winningMoney = winningMoney;
    }

    public static Prize valueOf(final int matchedCount, final boolean matchedBonus) {
        if (matchedCount == SECOND.matchedCount && matchedBonus) {
            return SECOND;
        }

        return Arrays.stream(PRIZES)
                .filter(p -> p.matchedCount == matchedCount)
                .filter(p -> p != SECOND)
                .findFirst()
                .orElse(NONE);
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
