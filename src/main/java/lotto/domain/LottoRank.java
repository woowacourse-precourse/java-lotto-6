package lotto.domain;

public enum LottoRank {
    NONE(0, false, 0),
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH_NO_BONUS(5, false, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int winningMoney;

    LottoRank(int matchCount, boolean bonusMatch, int winningMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank getLottoRank(int matchCount, boolean bonusMatch) {
        if (matchCount < 3) {
            return NONE;
        }
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_WITH_BONUS;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount(matchCount) && rank != FIVE_MATCH_WITH_BONUS) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean matchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

}
