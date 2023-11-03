package lotto.model;

public enum WinningPrize {
    FIRST_PRIZE(2_000_000_000, 6),
    SECOND_PRIZE(30_000_000, 5),
    THIRD_PRIZE(1_500_000, 5),
    FOURTH_PRIZE(50_000, 4),
    FIFTH_PRIZE(5_000, 3),
    ;

    private final long reward;
    private final int matchCount;

    WinningPrize(long reward, int matchCount) {
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public long getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
