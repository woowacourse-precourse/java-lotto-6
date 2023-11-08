package lotto.domain;

public enum LottoReward {
    FIFTH(5000,0),
    FOURTH(50000,0),
    THIRD(1500000,0),
    SECOND(30000000,0),
    FIRST(2000000000,0);

    private int reward;
    private int count;

    LottoReward(int reward, int count) {
        this.reward = reward;
        this.count = count;
    }

    public void winningReward() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public int totalReward() {
        return reward * count;
    }

}
