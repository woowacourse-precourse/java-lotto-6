package lotto.util;

import java.text.DecimalFormat;

public class EarningsCalculator {
    private EarningsCalculator() {
    }

    public static String calculateEarningsRate(int winningAmount, int purchaseAmount) {
        double earningsRate = (double) winningAmount * 100 / purchaseAmount;
        double roundedEarningsRate = Math.round(earningsRate * 10) / 10.0;

        DecimalFormat format = new DecimalFormat("0.0");
        String formattedRate = format.format(roundedEarningsRate);

        return formattedRate + "%";
    }
}
