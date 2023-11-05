package lotteryProfit;

public class ProfitCalculator {
    public double roundUpProfit(int totalReward, int purchaseAmount) {
        double profit = profitCalculator(totalReward, purchaseAmount);
        return Math.round(profit * 100.0) / 100.0;
    }

    private double profitCalculator(int totalReward, int purchaseAmount) {
        return (double) totalReward / purchaseAmount * 100;
    }
}