package lotto.domain;

public enum Ranking {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000)
    ;

    private final Integer reward;

    Ranking(Integer reward) {
        this.reward = reward;
    }

    public Integer reward() {
        return reward;
    }
}
