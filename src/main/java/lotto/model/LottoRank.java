package lotto.model;

public enum LottoRank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_AND_BONUS_MATCH(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final double prizeMoney;

    LottoRank(int matchCount, double prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }
}
