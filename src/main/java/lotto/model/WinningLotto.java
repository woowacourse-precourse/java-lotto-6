package lotto.model;

import java.util.Arrays;

public enum WinningLotto {
    ZERO(0, 0),
    ONE(0, 1),
    TWO(0, 2),
    THREE(5_000, 3),
    FOUR(50_000, 4),
    FIVE(1_500_000, 5),
    BONUS(30_000_000, 5),
    SIX(2_000_000_000, 6),
    ;

    private final int amounts;
    private final int matchCount;

    WinningLotto(int amounts, int matchCount) {
        this.amounts = amounts;
        this.matchCount = matchCount;
    }

    public static WinningLotto from(int matchCount) {
        return Arrays.stream(WinningLotto.values())
                .filter(s -> s.matchCount == matchCount)
                .findFirst()
                .orElse(ZERO);
    }

    public boolean isBonus() {
        return this == BONUS;
    }

    public int getAmounts() {
        return amounts;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
