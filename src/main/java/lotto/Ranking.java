package lotto;

public enum Ranking {
    First(2000000000),
    Second(30000000),
    Third(1500000),
    Fourth(50000),
    Fifth(5000);

    private final int prizeMoney;

    Ranking(final int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
