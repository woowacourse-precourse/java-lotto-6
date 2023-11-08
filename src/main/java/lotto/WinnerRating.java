package lotto;

public enum WinnerRating {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NO_LUCK(0);

    private final long reward;

    WinnerRating(long reward) {
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }
}
