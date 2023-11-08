package lotto;

public enum PrizeCategory {
    NONE(0, 0, ""),
    THREE_MATCHES(3, 5_000, "3개 일치 (5,000원)"),
    FOUR_MATCHES(4, 50_000, "4개 일치 (50,000원)"),
    FIVE_MATCHES(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FIVE_AND_BONUS_MATCHES(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCHES(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int prizeAmount;
    private final String matchText;

    PrizeCategory(int matchCount, int prizeAmount, String matchText) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.matchText = matchText;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getMatchText() {
        return matchText;
    }

    public static PrizeCategory valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) {
            return FIVE_AND_BONUS_MATCHES;
        }
        for (PrizeCategory value : values()) {
            if (value.getMatchCount() == matchCount) {
                return value;
            }
        }
        return NONE;
    }
}
