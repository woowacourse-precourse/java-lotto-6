package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false,50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "");

    private int matchingCount;
    private boolean bonusMatch;
    private int prizeAmount;
    private String prizeMessage;

    LottoRank(int matchingCount, boolean bonusMatch, int prizeAmount, String prizeMessage) {
        this.matchingCount = matchingCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
        this.prizeMessage = prizeMessage;
    }

    public static LottoRank getRank(int matchingCount, boolean bonusMatch) {
        if (SECOND.matchingCount == matchingCount && bonusMatch) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.matchingCount == matchingCount && rank != SECOND) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public String getPrizeMessage() {
        return prizeMessage;
    }
}
