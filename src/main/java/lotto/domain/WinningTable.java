package lotto.domain;

public enum WinningTable {
    NOT_WINNING(0, false, 0, ""),
    FIFTH_PRIZE(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH_PRIZE(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD_PRIZE(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND_PRIZE(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PRIZE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private int correctNumberCount;
    private boolean isBonus;
    private int winningAmount;
    private String message;

    WinningTable(int corectNumberCount, boolean isBonus, int winningAmount, String message) {
        this.correctNumberCount = corectNumberCount;
        this.isBonus = isBonus;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public boolean getIsBonus() {
        return isBonus;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getMessage() {
        return message;
    }
}