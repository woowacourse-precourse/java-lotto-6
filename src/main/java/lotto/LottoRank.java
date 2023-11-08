package lotto;

public enum LottoRank {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000"),
    FAIL(0, "0");

    private final int matchedCount;
    private final String prizeMoney;

    LottoRank(int matchedCount, String prizeMoney) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
}
