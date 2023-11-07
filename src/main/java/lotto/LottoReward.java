package lotto;

public enum LottoReward {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FORTH_PLACE(50000),
    FIFTH_PLACE(5000);

    private final int reward;
    LottoReward(int reward){
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
