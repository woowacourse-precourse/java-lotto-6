package lotto.model;

public class ProfitCalculator {
    public ProfitCalculator() {
    }

    public double calculateProfit(WinningStatistics winningStatistics, int purchasePrice) {
        int three = winningStatistics.getThree();
        int four = winningStatistics.getFour();
        int five = winningStatistics.getFive();
        int fiveWithBonus = winningStatistics.getFiveWithBonus();
        int six = winningStatistics.getSix();

        double profit =
                three * 5_000 + four * 50_000 + five * 1_500_000 + fiveWithBonus * 30_000_000 + six * 2_000_000_000;

        double profitPercentage = profit / (double) purchasePrice * 100;
        int decimalPlaces = 2;
        return Math.round(profitPercentage * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);

    }
}
