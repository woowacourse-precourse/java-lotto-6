package domain.result;

import java.util.stream.Stream;

public enum WinningResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private int matchCount;
    private int reward;

    WinningResult(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static WinningResult getWinningResult(int matchCount, boolean matchBonus) {
        if (matchCount == THIRD.matchCount && !matchBonus) {
            return THIRD;
        }

        return Stream.of(values())
                .filter(result -> result.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);

    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
