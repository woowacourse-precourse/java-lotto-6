package lotto.domain;

public enum Prize {
    FIRST_REWARD(1,2000000000),
    SECOND_REWARD(2,30000000),
    THIRD_REWARD(3,1500000),
    FOURTH_REWARD(4,50000),
    FIFTH_REWARD(5,5000);

    private final int rank;
    private final int reward;

    Prize(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }
}
