package lotto.service;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import lotto.utility.PrizeUnit;

public class RateCalculator {
    public static int calculateWinnings(List<Integer> resultList) {
        int totalWinnings = 0;
        for (int i = 0; i < resultList.size(); i++) {
            totalWinnings += resultList.get(i) * PrizeUnit.values()[i].getPrizeUnitAmount();
        }
        return totalWinnings;
    }

    public static double calculateRate(int purchaseAmount, List<Integer> resultList) {
        double profitPercentage = (double) calculateWinnings(resultList) / purchaseAmount * 100;
        return Math.round(profitPercentage * 10.0) / 10.0;
    }

    public static String converseRate(int purchaseAmount, List<Integer> resultList) {
        double winnings = RateCalculator.calculateRate(purchaseAmount, resultList);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        numberFormat.setMinimumFractionDigits(1);
        return numberFormat.format(winnings);
    }
}
