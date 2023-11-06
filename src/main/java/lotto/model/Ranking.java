package lotto.model;

public enum Ranking {

    FIFTH(3, 5, "5,000"),
    FOURTH(4, 4, "50,000"),
    THIRD(5, 3, "1,500,000"),
    SECOND(5, 2, "30,000,000"),
    FIRST(6, 1, "2,000,000,000"),
    NONE(0, 0, "0");


    private final int matchedCount;
    private final int rank;
    private final String winnings;

    Ranking(int matchedCount, int rank, String winnings) {
        this.matchedCount = matchedCount;
        this.rank = rank;
        this.winnings = winnings;
    }

    public static Ranking of(int matchedCount, boolean isMatchBonus) {
        if (SECOND.matchedCount == matchedCount && isMatchBonus) {
            return SECOND;
        }
        for (Ranking ranking : values()) {
            if (ranking.matchedCount == matchedCount && ranking.rank != 2) {
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
    public String getWinnings(){
        return winnings;
    }
}
