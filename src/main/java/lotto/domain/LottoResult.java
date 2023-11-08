package lotto.domain;

public enum LottoResult {
    NONE(0, 0, "0원"),
    FIFTH(3, 5_000, "5,000원"),
    FOURTH(4, 50_000, "50,000원"),
    THIRD(5, 1_500_000, "1,500,000원"),
    SECOND(5, 30_000_000, "30,000,000원"),
    FIRST(6, 2_000_000_000, "2,000,000,000원");

    private final int matchCount;
    private final int prizeMoney;
    private final String prizeString;

    LottoResult(int matchCount, int prizeMoney, String prizeString) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.prizeString = prizeString;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeString() {
        return prizeString;
    }

    public static LottoResult valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        for (LottoResult result : values()) {
            if (result.getMatchCount() == matchCount && result != SECOND) {
                return result;
            }
        }

        return NONE;
    }
}
