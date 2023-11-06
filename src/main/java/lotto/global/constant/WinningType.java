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

    public static WinningType findByMatchCount(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) {
            return  WinningType.FIRST;
        }
        if (matchCount == 5) {
            return getWinningTypeByBonusOrNot(isBonusMatch);
        }
        if (matchCount == 4) {
            return WinningType.FOURTH;
        }
        if (matchCount == 3) {
            return WinningType.FIFTH;
        }
        return WinningType.OTHER;
    }

    private static WinningType getWinningTypeByBonusOrNot(boolean isBonusMatch) {
        if (isBonusMatch) {
            return WinningType.SECOND;
        }
        return THIRD;
    }
}
