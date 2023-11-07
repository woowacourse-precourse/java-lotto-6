package lotto.model;

import java.util.Map;

public class YieldCalculator {
    private final int WINNING_MONEY_3 = 5000;
    private final int WINNING_MONEY_4 = 50000;
    private final int WINNING_MONEY_5 = 1500000;
    private final int WINNING_BONUS_MONEY_5 = 30000000;
    private final int WINNING_MONEY_6 = 2000000000;
    public double winningMoney;
    public double yeild;

    public double calculateYieldCalculator(Map<String, Integer> winningResults, int purchasePrice) {
        double winningMoney = getSumOfResult(winningResults);
        yeild = (winningMoney - purchasePrice) / purchasePrice * 100;
        return yeild;
    }

    private double getSumOfResult (Map<String, Integer> winningResults) {
        winningMoney += winningResults.get("3") * WINNING_MONEY_3
                + winningResults.get("4") * WINNING_MONEY_4
                + winningResults.get("5") * WINNING_MONEY_5
                + winningResults.get("5_bonus") * WINNING_BONUS_MONEY_5
                + winningResults.get("6") * WINNING_MONEY_6;
        return winningMoney;
    }
}
