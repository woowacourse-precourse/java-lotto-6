package util;

public enum PrizeMoney {
    PRIZE_MONEY_5TH(5000.0),
    PRIZE_MONEY_4TH(50000.0),
    PRIZE_MONEY_3RD(1500000.0),
    PRIZE_MONEY_2ND(30000000.0),
    PRIZE_MONEY_1ST(2000000000.0);

    private final double prizeMoney;

    PrizeMoney(double prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }

}
