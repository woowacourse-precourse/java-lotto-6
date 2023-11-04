package lotto.domain;

import java.util.Arrays;

public enum WinningStatistics {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    MISS(0, 0, 0);

    private final int matchCount;
    private final int matchBonusCount;
    private final int reward;

    WinningStatistics(int matchCount, int matchBonusCount, int reward) {
        this.matchCount = matchCount;
        this.matchBonusCount = matchBonusCount;
        this.reward = reward;
    }

    public static WinningStatistics of(int matchCount, int matchBonusCount) {
        return Arrays.stream(WinningStatistics.values())
                .filter(value -> value.matchCount == matchCount && value.matchBonusCount == matchBonusCount)
                .findFirst()
                .orElse(MISS);
    }

    public boolean hasBonusCount() {
        return matchBonusCount > 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
