package lotto.enums;

public enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int reward;

    Rank(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
