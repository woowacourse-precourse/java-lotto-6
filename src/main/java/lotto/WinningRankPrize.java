package lotto;

public enum WinningRankPrize {

    FIFTH(5, 0,"3개 일치", "5,000"),
    FOURTH(4, 0,"4개 일치", "50,000"),
    THIRD(3, 0,"5개 일치", "1,500,000"),
    SECOND(2, 0,"5개 일치, 보너스 볼 일치", "30,000,000"),
    FIRST(1, 0,"6개 일치", "2,000,000,000");

    private int rank;
    private int winCount;
    private String matchCount;
    private String prizeAmount;

    WinningRankPrize(int rank, int winCount, String matchCount, String prizeAmount) {
        this.rank = rank;
        this.winCount = winCount;
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getRank() { return rank; }

    public int getWinCount() { return winCount; }

    public void increaseWinCount() { this.winCount = winCount + 1; }

    public String getMatchCount() {
        return matchCount;
    }

    public String getPrizeAmount() { return prizeAmount; }

}
