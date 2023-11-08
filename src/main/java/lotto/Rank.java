package lotto;

public enum Rank {
    FIRST(1, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(0, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(2, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(3, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(4, 5_000, "3개 일치 (5,000원) - "), // 5등
    Fail(7, 0, "");

    private final int countOfMatch;
    private final int winningAmount;
    private final String winningMessage;

    Rank(int countOfMatch, int winningAmount, String message) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
        this.winningMessage = message;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
