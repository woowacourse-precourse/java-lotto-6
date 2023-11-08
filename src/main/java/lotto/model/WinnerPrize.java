package lotto.model;

public enum WinnerPrize {

    THREE_CORRECT(3, 5000),
    FOUR_CORRECT(4, 50000),
    FIVE_CORRECT(5, 1500000),
    FIVE_ONE_CORRECT(5.5F, 30000000),
    SIX_CORRECT(6, 2000000000);

    private final float correctCount;
    private final int prize;

    WinnerPrize(float correctCount, int prize) {
        this.correctCount = correctCount;
        this.prize = prize;
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
