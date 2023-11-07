package lotto.util.constants;

public enum Prize {
    FIFTH(5, 5000L),
    FOURTH(4, 50000L),
    THIRD(3, 1500000L),
    SECOND(2, 30000000L),
    FIRST(1, 2000000000L);

    private final int rank;
    private final long reward;

    Prize(int rank, long reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public int getRank() {
        return rank;
    }

    public long getReward() {
        return reward;
    }
}
