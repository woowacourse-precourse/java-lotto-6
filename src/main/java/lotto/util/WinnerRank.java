package lotto.util;

public enum WinnerRank {
    THREE(3, 5000, 3),
    FOUR(4, 50000, 4),
    FIVE_WITHOUT_BOUNUS(5, 1500000, 5),
    FIVE_WITH_BONUS(7, 30000000, 5),
    SIX(6, 2000000000, 6); //출력을 위해 변경

    int rankKey;
    int prizeMoney;
    int sameNumberCount;

    private WinnerRank(int rankKey, int prizeMoney, int sameNumberCount) {
        this.rankKey = rankKey;
        this.prizeMoney = prizeMoney;
        this.sameNumberCount = sameNumberCount;
    }

    public int getRankKey() {
        return rankKey;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }
}
