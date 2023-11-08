package lotto.domain.valueobject;

public class Reward {
    private final long reward;

    public Reward(long reward) {
        this.reward = reward;
    }

    public long getValue() {
        return reward;
    }
}
