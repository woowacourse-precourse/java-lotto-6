package lotto.Util;

public enum WinningStatistics {
    THREE_MATCH("3개 일치 (5,000원) - ", 3, 5000),
    FOUR_MATCH("4개 일치 (50,000원) - ", 4, 50000),
    FIVE_MATCH("5개 일치 (1,500,000원) - ", 5, 1500000),
    FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 6, 30000000),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ", 7, 2000000000);

    private final String message;
    private final int matchNumber;
    private final int reward;

    WinningStatistics(String message, int matchNumber, int reward) {
        this.message = message;
        this.matchNumber = matchNumber;
        this.reward = reward;
    }

    public String getMessage() {
        return this.message;
    }

    public int getReward() {
        return this.reward;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }
}
