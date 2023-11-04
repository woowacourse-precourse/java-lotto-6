package lotto.domain;

public enum Rank {
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    private final Integer PRIZE_MONEY;

    Rank(Integer prizeMoney) {
        this.PRIZE_MONEY = prizeMoney;
    }

    public Integer getPrizeMoney() {
        return PRIZE_MONEY;
    }
}
