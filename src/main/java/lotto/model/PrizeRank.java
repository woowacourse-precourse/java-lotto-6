package lotto.model;

public enum PrizeRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int price;

    PrizeRank(int matchCount, boolean bonusMatch, int price) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.price = price;
    }

    public static PrizeRank findPrizeRankByMatches(int matchCount, boolean hasBonus) {
        for (PrizeRank rank : PrizeRank.values()) {
            if (rank.isWinningRank(matchCount, hasBonus)) {
                return rank;
            }
        }
        return null;
    }

    public boolean isWinningRank(int count, boolean hasBonus) {
        return this.matchCount == count && (!this.bonusMatch || hasBonus);
    }
}