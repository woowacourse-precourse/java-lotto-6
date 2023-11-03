package lotto.domain;

public enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final Integer winningPrize;

    Rank(Integer winningPrize) {
        this.winningPrize = winningPrize;
    }

    public int getPrize() {
        return winningPrize;
    }
}
