package lotto.view;

public enum LottoResult {
    LOSING(0, "0", 0),
    FIFTH(3, "5,000", 5),
    FOURTH(4, "50,000", 4),
    THIRD(5, "1,500,000", 3),
    SECOND(5, "3,000,000", 2),
    FIRST(6, "2,000,000,000", 1);

    private final int matchCount;
    private final String winPrizeMoney;
    private final int rankIndex;

    LottoResult(int matchCount, String winPrizeMoney, int rankIndex) {
        this.matchCount = matchCount;
        this.winPrizeMoney = winPrizeMoney;
        this.rankIndex = rankIndex;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getWinPrizeMoney() {
        return winPrizeMoney;
    }

    public int getRankIndex() {
        return rankIndex;
    }
}
