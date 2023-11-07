package lotto;

public enum WinningRankPrize {

    FIFTH(5, "3개 일치", "5,000"),
    FOURTH(4, "4개 일치", "50,000"),
    THIRD(3, "5개 일치", "1,500,000"),
    SECOND(2, "5개 일치, 보너스 볼 일치", "30,000,000"),
    FIRST(1, "6개 일치", "2,000,000,000");

    private int rank;
    private String matchCount;
    private String prizeAmount;

    WinningRankPrize(int rank, String matchCount, String prizeAmount) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getRank() { return rank; }

    public String getMatchCount() {
        return matchCount;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

}
