package lotto;

public enum PrizeGrade {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NO_PRIZE(0);

    private final int prizeMoney;

    PrizeGrade(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

}
