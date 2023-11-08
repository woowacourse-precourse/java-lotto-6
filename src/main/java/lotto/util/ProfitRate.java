package lotto.util;

public class ProfitRate {
    public static String calculateProfit(int totalPrize, int purchasePrice) {
        double result =  ((double) totalPrize / purchasePrice) * 100;
        return String.format("%.1f", result);
    }
}
