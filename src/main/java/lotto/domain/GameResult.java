package lotto.domain;

public enum GameResult {
    FIFTH_PRIZE(3, 5000L, false, 0),
    FOURTH_PRIZE(4, 50000L, false, 0),
    THIRD_PRIZE(5, 1500000L, false, 0),
    SECOND_PRIZE(5, 30000000L, true, 0),
    FIRST_PRIZE(6, 2000000000L, false, 0);

    private final int matchCount;
    private final long prizeMoney;
    private final boolean isBonus;
    private int resultCount;

    GameResult(int matchCount, long prizeMoney, boolean isBonus, int resultCount) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonus = isBonus;
        this.resultCount = resultCount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }

    public boolean getIsBonus() {
        return this.isBonus;
    }

    public int getResultCount() {
        return this.resultCount;
    }

    public void increaseResultCount() {
        this.resultCount++;
    }

    public void clearResultCount() {
        this.resultCount = 0;
    }
}
