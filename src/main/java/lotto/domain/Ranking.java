package lotto.domain;

public enum Ranking {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NONE(0, 0)
    ;

    private final Integer rank;
    private final Integer reward;

    Ranking(Integer rank, Integer reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public Integer rank() {
        return rank;
    }

    public Integer reward() {
        return reward;
    }
}
