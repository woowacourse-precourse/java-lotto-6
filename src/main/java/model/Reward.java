package model;

public enum Reward {
    FIFTH(3,5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6,2000000000);

    private int sameCount;
    private int reward;

    Reward(int sameCount, int reward) {
        this.sameCount = sameCount;
        this.reward = reward;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getReward() {
        return reward;
    }
}
