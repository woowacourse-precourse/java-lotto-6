package lotto.enums;

public enum PrizeMoney {
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private long money;

    PrizeMoney(long money) {
        this.money = money;
    }

    public long getPrizeMoney() {
        return money;
    }
}
