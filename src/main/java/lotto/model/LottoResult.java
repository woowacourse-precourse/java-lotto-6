package lotto.model;

public enum LottoResult {
    THREE_MATCHES(3, 5000, "3개 일치 (5,000원)", false),
    FOUR_MATCHES(4, 50000, "4개 일치 (50,000원)", false),
    FIVE_MATCHES(5, 1500000, "5개 일치 (1,500,000원)", false),
    FIVE_MATCHES_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)", true),
    SIX_MATCHES(6, 2000000000, "6개 일치 (2,000,000,000원)", false),
    NON_WINNING(0, 0, "당첨되지 않음", false);

    private final int matchCount;
    private final int winPrize;
    private final String resultDescription;
    private final boolean bonusMatch;

    LottoResult(int matchCount, int winPrize, String resultDescription, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.winPrize = winPrize;
        this.resultDescription = resultDescription;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinPrize() {
        return winPrize;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}