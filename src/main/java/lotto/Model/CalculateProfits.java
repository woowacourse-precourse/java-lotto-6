package lotto.Model;

import java.util.List;

public class CalculateProfits {
    public static String calculate(List<Integer> countWinnings, double investment) {
        double profit = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            int prizeCount = countWinnings.get(prize.ordinal());
            profit += prizeCount * prize.getPrize();
        }
        double profitPercentage = (profit / investment) * 100;
        String roundedProfitPercentage = roundToTwoDecimalPlaces(profitPercentage);
        System.out.println("총 수익률은 " + roundedProfitPercentage + "% 입니다.");
        return roundedProfitPercentage;
    }
    private static String roundToTwoDecimalPlaces(double value) {
        double roundedValue = Math.round(value * 100.0) / 100.0;
        return String.format("%.2f", roundedValue);
    }

}
