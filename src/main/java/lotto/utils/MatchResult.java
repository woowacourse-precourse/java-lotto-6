package lotto.utils;

public enum MatchResult {
    THREE_MATCH(3, 0, 5000),
    FOUR_MATCH(4, 1, 50000),
    FIVE_MATCH(5, 2, 1500000),
    FIVE_PLUS_BONUS_MATCH(5, 3, 30000000),
    SIX_MATCH(6, 4, 2000000000);

    private final int matchCount;
    private final int prizeIndex;
    private final int prizeAmount;

    MatchResult(int matchCount, int prizeIndex, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeIndex = prizeIndex;
        this.prizeAmount = prizeAmount;
    }

    public static MatchResult valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) return FIVE_PLUS_BONUS_MATCH;
        for (MatchResult result : MatchResult.values()) {
            if (result.matchCount == matchCount) return result;
        }
        return null;
    }

    public int getPrizeIndex() {
        return this.prizeIndex;
    }

    public int getPrizeAmount() {
        return this.prizeAmount;
    }
}
