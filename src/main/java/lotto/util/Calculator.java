package lotto.util;

import java.text.DecimalFormat;

public class Calculator {
    public static double getRevenue(int purchaseAmount, int winningAmount) {
        double profit = calculateProfit(purchaseAmount, winningAmount);
        return roundToTwoDecimalPlaces(profit);
    }

    private static double calculateProfit(int initialInvestment, int finalValue) {
        return ((double) (finalValue) / initialInvestment) * 100.0;
    }

    public static double roundToTwoDecimalPlaces(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(number));
    }
}
