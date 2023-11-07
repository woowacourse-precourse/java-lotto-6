package view;

public enum Ranking {

    FIRST(6, 2_000_000_000, "6개 일치(2,000,000,000원 - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    MISS(0, 0, "");

    private int matchingCount;
    private int winningAmount;
    private String winningMessage;

    Ranking(int matchingCount, int winningAmount, String winningMessage) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
        this.winningMessage = winningMessage;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public void setMatchingCount(int matchingCount) {
        this.matchingCount = matchingCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public void setWinningMessage(String winningMessage) {
        this.winningMessage = winningMessage;
    }

    public static Ranking value(int matchingCount, boolean bonusCount) {
        if (matchingCount < 3) {
            return MISS;
        }
        return FIRST;
    }


}
