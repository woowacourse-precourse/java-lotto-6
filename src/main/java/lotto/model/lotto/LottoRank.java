package lotto.model.lotto;

public enum LottoRank {
    FAIL(0, false, 0, ""),
    RANK5(3, false, 5_000, "3개 일치 (5,000원) - "),
    RANK4(4, false, 50_000, "4개 일치 (50,000원) - "),
    RANK3(5, false, 5_000, "5개 일치 (1,500,000원) - "),
    RANK2(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK1(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");


    private final int matchCount;
    private final boolean bonusMatch;
    private final int amount;
    private final String message;

    LottoRank(int matchCount, boolean bonusMatch, int amount, String message) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.amount = amount;
        this.message = message;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount && rank.isBonusMatch() == matchBonus) {
                return rank;
            }
        }
        return FAIL;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getAmount() {
        return amount;
    }

    public String getMsg() {
        return message;
    }


}
