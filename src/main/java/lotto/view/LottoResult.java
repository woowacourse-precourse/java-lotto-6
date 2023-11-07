package lotto.view;

public enum LottoResult {
    LOSING(0, "0"),
    FIFTH(3, "5,000"),
    FOURTH(4, "50,000"),
    THIRD(5, "1,500,000"),
    SECOND(5, "3,000,000"),
    FIRST(6, "2,000,000,000");


    private final int matchCount;
    private final String winPrizeMoney;

    LottoResult(int matchCount, String winPrizeMoney) {
        this.matchCount = matchCount;
        this.winPrizeMoney = winPrizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getWinPrizeMoney() {
        return winPrizeMoney;
    }
}
