package lotto;

public enum MatchingCount {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 15000000),
    FIVEBONUS(5.5f, 30000000),
    SIX(6, 2000000000);

    private final float matchCount;
    private final int prizeMoney;

    MatchingCount(float matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }
}
