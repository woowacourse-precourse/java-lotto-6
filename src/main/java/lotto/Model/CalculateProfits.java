package lotto.Model;

import java.util.List;
import lotto.View.OuputView;

public class CalculateProfits {
    public static void calculate(List<Integer> countWinnings, double investment) {
        double profit = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            int prizeCount = countWinnings.get(prize.ordinal());
            profit += prizeCount * prize.getPrize();
        }
        double profitPercentage = (profit / investment) * 100;
        //System.out.println("총 수익률은 " + roundToTwoDecimalPlaces(profitPercentage) + "%입니다.");
        OuputView.printProfit(roundToTwoDecimalPlaces(profitPercentage));
    }

    private static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
