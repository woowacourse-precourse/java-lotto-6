package lotto;

public enum LottoRank {
    NONE(0, 0, "꽝"),
    THREE_MATCHES(3, 5_000, "3개 일치 (5,000원)"),
    FOUR_MATCHES(4, 50_000, "4개 일치 (50,000원)"),
    FIVE_MATCHES(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FIVE_WITH_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCHES(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int winningMoney;
    private final String resultText;

    LottoRank(int matchCount, int winningMoney, String resultText) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.resultText = resultText;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getResultText() {
        return resultText;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return FIVE_WITH_BONUS;
        }

        for (LottoRank rank : values()) {
            if (rank.getMatchCount() == matchCount && rank != FIVE_WITH_BONUS) {
                return rank;
            }
        }

        return NONE;
    }
}
