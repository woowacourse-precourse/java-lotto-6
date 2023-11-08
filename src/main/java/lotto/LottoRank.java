package lotto;

enum LottoRank {
    THREE_MATCH(3, 5000, 0, "3개 일치 (5,000원) - "),
    FOUR_MATCH(4, 50000, 0, "4개 일치 (50,000원) - "),
    FIVE_MATCH(5, 1500000, 0, "5개 일치 (1,500,000원) - "),
    FIVE_MATCH_WITH_BONUS(5, 30000000, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH(6, 2000000000, 0, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final int prize;

    private int additionalMatches;

    private String prizeInfo = "";

    LottoRank(int matchCount, int prize, int additionalMatches, String prizeInfo) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.additionalMatches = additionalMatches;
        this.prizeInfo = prizeInfo;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getAdditionalMatches() {
        return additionalMatches;
    }

    public String getPrizeInfo() {
        return prizeInfo;
    }

    public static int getByCountAndBonus(int count, boolean hasBonus) {
        if (count == 5 && hasBonus) {
            return FIVE_MATCH_WITH_BONUS.additionalMatches++;
        }
        return getByCount(count);
    }

    public static int getByCount(int count) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == count) {
                return rank.additionalMatches++;
            }
        }
        return 0;
    }
}
