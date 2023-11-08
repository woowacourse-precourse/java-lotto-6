package lotto.service;

public enum Reward {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(50000),
    FIFTH_PLACE(5000),
    LOSE(0);
    private final int reward;

    Reward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }
}
