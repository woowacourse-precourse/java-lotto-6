package lotto.model;

public enum WinnerPrize {

    THREE_CORRECT(3, 5000, "3개 일치 (5,000원)"),
    FOUR_CORRECT(4, 50000, "4개 일치 (50,000원)"),
    FIVE_CORRECT(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_ONE_CORRECT(5.5F, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_CORRECT(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final float correctCount;
    private final int prize;
    private final String description;

    WinnerPrize(float correctCount, int prize, String description) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static WinnerPrize findWinnerPrize(float correctCount) {
        WinnerPrize[] allWinnerPrize = getAllWinnerPrize();
        for (WinnerPrize winnerPrize : allWinnerPrize) {
            if (winnerPrize.correctCount == correctCount) {
                return winnerPrize;
            }
        }
        return null; // TODO: refactoring
    }

    public static WinnerPrize[] getAllWinnerPrize() {
        return WinnerPrize.values();
    }
}
