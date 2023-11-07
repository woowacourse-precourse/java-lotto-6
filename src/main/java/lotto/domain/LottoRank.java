package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000, 6, false),
    SECOND(1_500_000, 5, true),
    THIRD(50_000, 5, false),
    FOURTH(5_000, 4, false),
    FIFTH(500, 3, false),
    NONE(0, 0, false);

    private final int winningAmount;
    private final int matchCount;
    private final boolean bonusMatch;

    LottoRank(int winningAmount, int matchCount, boolean bonusMatch) {
        this.winningAmount = winningAmount;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.bonusMatch || bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }
}
