package lotto.util;

public class ProfitRate {

    // 이후에 printProfit은 OutputView로 이동가능
    public static String calculateProfit(int totalPrize, int purchasePrice) {
        double result =  ((double) totalPrize / purchasePrice) * 100;
        return String.format("%.1f", result);
    }
}
