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

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
