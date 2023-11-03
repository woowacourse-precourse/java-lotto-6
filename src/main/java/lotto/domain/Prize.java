package lotto.domain;

public enum Prize {
    FIRST_REWARD(2000000000, 6),
    SECOND_REWARD(30000000, 5),
    THIRD_REWARD(1500000, 5),
    FOURTH_REWARD(50000, 4),
    FIFTH_REWARD(5000, 3);

    private final int reward;
    private final int matchCount;

    Prize(int reward, int matchCount) {
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
