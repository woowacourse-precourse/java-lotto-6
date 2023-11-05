package lotto.util;

public enum WinnerRank {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE_WITHOUT_BOUNUS(5, 1500000),
    SIX(6, 2000000000),
    FIVE_WITH_BONUS(7, 30000000);

    int value;
    int prizeMoney;

    private WinnerRank(int value, int prizeMoney) {
        this.value = value;
        this.prizeMoney = prizeMoney;
    }

    public int getValue() {
        return value;
    }
    public int getPrizeMoney() {
        return prizeMoney;
    }
}
