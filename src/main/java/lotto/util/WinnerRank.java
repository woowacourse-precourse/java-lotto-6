package lotto.util;

public enum WinnerRank {
    THREE(3, 5000, 3),
    FOUR(4, 50000, 4),
    FIVE_WITHOUT_BOUNUS(5, 1500000, 5),
    SIX(6, 2000000000, 6),
    FIVE_WITH_BONUS(7, 30000000, 5);

    int value;
    int prizeMoney;
    int sameNumberCount;

    private WinnerRank(int value, int prizeMoney, int sameNumberCount) {
        this.value = value;
        this.prizeMoney = prizeMoney;
        this.sameNumberCount = sameNumberCount;
    }

    public int getValue() {
        return value;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }
}
