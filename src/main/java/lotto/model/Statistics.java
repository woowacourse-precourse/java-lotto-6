package lotto.model;

public class Statistics {
    private final int matchCount;
    private final boolean isMatchBonus;

    public Statistics(int matchCount, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}
