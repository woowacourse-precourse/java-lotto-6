package lotto.global.constant;

public enum WinningType {

    OTHER(0),
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private final long revenue;

    WinningType(long revenue) {
        this.revenue = revenue;
    }

    public long getRevenue() {
        return revenue;
    }
}
