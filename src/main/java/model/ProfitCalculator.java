package model;

import java.text.DecimalFormat;

public class ProfitCalculator {
    private final static int[] MONEY_OF_WINNING = {5000, 50000, 1500000,
            30000000, 2000000000};

    private ProfitCalculator() {
    }

    public static String calculateRateOfProfit(String money, int profit)
    {
        double profitRate = ((double)profit / Integer.parseInt(money)) * 100;

        DecimalFormat df = new DecimalFormat("#.0");
        String formatted = df.format(profitRate);

        return formatted;
    }

    public static int calculateProfit(int[] result)
    {
        int profit = 0;
        for(int i = 0; i < result.length; i++)
        {
            profit += MONEY_OF_WINNING[i]*result[i];
        }
        return profit;
    }
}
