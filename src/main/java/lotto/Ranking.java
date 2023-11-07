package lotto;

public enum Ranking {
    THREE_MATCHES(3, "3개 일치 (5,000원) - ", 5_000),
    FOUR_MATCHES(4, "4개 일치 (50,000원) - ", 50_000),
    FIVE_MATCHES(5, "5개 일치 (1,500,000원) - ", 1_500_000),
    FIVE_MATCHES_BOUNS_MATCHES(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    SIX_MATCHES(6, "6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private final int matchCount;
    private final String winningMessage;
    private final int winningAmount;

    Ranking(int matchCount, String winningMessage, int winningAmount) {
        this.matchCount = matchCount;
        this.winningMessage = winningMessage;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
