package lotto;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchedCount;
    private final int prizeMoney;

    Prize(int matchedCount, int prizeMoney) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}