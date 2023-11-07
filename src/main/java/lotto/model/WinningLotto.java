package lotto.model;

import java.util.Arrays;

public enum WinningLotto {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000),
    ;

    private final int matchCount;
    private final int amounts;

    WinningLotto(int matchCount, int amounts) {
        this.matchCount = matchCount;
        this.amounts = amounts;
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
