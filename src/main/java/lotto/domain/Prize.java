package lotto.domain;

public enum Prize {
    FIFTH(3,5000),
    FORTH(4,50000),
    THIRD(5,1500000),
    SECOND(-6,30000000),
    FIRST(6,2000000000);

    private final int threshold;
    private final int reward;
    Prize(int threshold, int reward) {
        this.threshold = threshold;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public int getThreshold() {
        return threshold;
    }
}
