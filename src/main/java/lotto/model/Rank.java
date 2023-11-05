package lotto.model;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000);

    private final int rank;
    private final int reward;

    Rank(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }
}
