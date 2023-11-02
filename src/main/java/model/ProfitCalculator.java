package model;

import java.text.DecimalFormat;

public class ProfitCalculator {

    private ProfitCalculator() {
    }

    public static String calculateRateOfProfit(String money, int profit)
    {
        double profitRate = ((double)profit / Integer.parseInt(money)) * 100;

        DecimalFormat df = new DecimalFormat("#.0");
        String formatted = df.format(profitRate);

        return formatted;
    }
}
