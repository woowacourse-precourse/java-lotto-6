package lotto.util;

import java.text.DecimalFormat;

public class ProfitCalculator {

    public static double calculateProfitPercentage(double purchaseAmount, double winningAmount) {
        double profitPercentage = (winningAmount / purchaseAmount) * 100.0;
        return roundToTwoDecimalPlaces(profitPercentage);
    }

    private static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}