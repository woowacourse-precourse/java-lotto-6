package lotto;

public enum WinningRank {
    FIRST_WINNING("6개 일치", "2,000,000,000"),
    SECOND_WINNING("5개 일치, 보너스 볼 일치", "30,000,000"),
    THIRD_WINNING("5개 일치", "1,500,000"),
    FOURTH_WINNING("4개 일치", "50,000"),
    FIFTH_WINNING("3개 일치", "5,000"),
    NO_LUCK("꽝", "0");
    private final String conditionsForWinning;
    private final String lotteryWinningAmount;

    WinningRank(String conditionsForWinning, String lotteryWinningAmount) {
        this.lotteryWinningAmount = lotteryWinningAmount;
        this.conditionsForWinning = conditionsForWinning;
    }

    public String getConditionsForWinning() {
        return conditionsForWinning;
    }

    public String getLotteryWinningAmount() {
        return lotteryWinningAmount;
    }
}
