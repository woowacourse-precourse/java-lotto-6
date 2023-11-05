package lotto;

public enum Rank {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    Rank(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
