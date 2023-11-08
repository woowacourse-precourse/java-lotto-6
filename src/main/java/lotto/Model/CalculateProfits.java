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
        OuputView.printProfit(profitPercentage);
    }
}
