package lotto.domain;

public enum Prize {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    None(0);

    private final int prizeMoney;

    Prize(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
