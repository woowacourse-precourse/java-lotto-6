package lotto.utils;

import java.text.DecimalFormat;

public class ProfitRateTwoDecimalRoundCalculator implements ProfitRateCalculator {

    @Override
    public double calculateProfitRate(final long profit, final int invested) {
        double profitRate = (double) profit / invested * 100.0;
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(profitRate));
    }
}
