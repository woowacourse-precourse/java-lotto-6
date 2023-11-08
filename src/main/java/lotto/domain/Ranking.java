package lotto.domain;

public enum Ranking {
    THREE_MATCH("3개 일치 (5,000원)", 5000, 3, false),
    FOUR_MATCH("4개 일치 (50,000원)", 50000, 4, false),
    FIVE_MATCH("5개 일치 (1,500,000원)", 1500000, 5, false),
    FIVE_MATCH_WITH_BONUS_MATCHED("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 5, true),
    SIX_MATCH("6개 일치 (2,000,000,000원)", 2000000000, 6, false);

    private final String message;
    private final int winningMoney;
    private final int matchCount;
    private final boolean bonusNumberRequired;

    Ranking(String message, int winningMoney, int matchCount, boolean bonusNumberRequired) {
        this.message = message;
        this.winningMoney = winningMoney;
        this.matchCount = matchCount;
        this.bonusNumberRequired = bonusNumberRequired;
    }

    public static Ranking findRankingWithResult(final int matchCount, final boolean bonusNumberMatched) {
        if (matchCount == 5) {
            return findRankingByBonusNumberMatched(bonusNumberMatched);
        }

        for (Ranking result : values()) {
            if (result.matchCount == matchCount) {
                return result;
            }
        }

        return null;
    }

    private static Ranking findRankingByBonusNumberMatched(final boolean bonusNumberMatched) {
        if (bonusNumberMatched) {
            return FIVE_MATCH_WITH_BONUS_MATCHED;
        }
        return FIVE_MATCH;
    }

    public String getMessage() {
        return this.message;
    }

    public static int calculateProfitByRanking(final Ranking ranking, final int count) {
        return ranking.winningMoney * count;
    }
}
