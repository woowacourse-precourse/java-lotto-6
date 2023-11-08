package lotto.domain;

public enum WinningResult {

    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)");

    private int correctNumberCount;
    private boolean isBonus;
    private int winningMoney;
    private String message;

    WinningResult(int correctNumberCount, boolean isBonus, int winningMoney, String message) {
        this.correctNumberCount = correctNumberCount;
        this.isBonus = isBonus;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return message;
    }
}
