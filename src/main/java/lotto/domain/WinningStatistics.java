package lotto.domain;

import java.util.Arrays;

public enum WinningStatistics {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean isMatchBonus;
    private final int reward;

    WinningStatistics(int matchCount, boolean isMatchBonus, int reward) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.reward = reward;
    }

    public static WinningStatistics of(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(WinningStatistics.values())
                .filter(value -> value.matchCount == matchCount && value.isMatchBonus == isMatchBonus)
                .findFirst()
                .orElse(MISS);
    }

    public boolean hasBonusCount() {
        return isMatchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
