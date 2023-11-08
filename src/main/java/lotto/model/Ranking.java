package lotto.model;

public enum Ranking {

    FIFTH(3, 5, "5,000", "3개 일치 (5,000원) - "),
    FOURTH(4, 4, "50,000", "4개 일치 (50,000원) - "),
    THIRD(5, 3, "1,500,000", "5개 일치 (1,500,000원) - "),
    SECOND(5, 2, "30,000,000", "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 1, "2,000,000,000", "6개 일치 (2,000,000,000원) - "),
    NONE(0, 0, "0", "0개 일치");


    private final int matchedCount;
    private final int rank;
    private final String winnings;
    private final String winningString;

    Ranking(int matchedCount, int rank, String winnings, String winningString) {
        this.matchedCount = matchedCount;
        this.rank = rank;
        this.winnings = winnings;
        this.winningString = winningString;
    }

    public static Ranking of(int matchedCount, boolean isMatchBonus) {
        if (SECOND.matchedCount == matchedCount && isMatchBonus) {
            return SECOND;
        }
        for (Ranking ranking : values()) {
            if (ranking.matchedCount == matchedCount && ranking.rank != SECOND.getRank()) {
                return ranking;
            }
        }
        return NONE;
    }

    public int getWinningsByInt() {
        return Integer.parseInt(winnings.replaceAll(",", ""));
    }

    public int getRank() {
        return rank;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public String getWinnings() {
        return winnings;
    }

    public String getWinningString() {
        return winningString;
    }
}
