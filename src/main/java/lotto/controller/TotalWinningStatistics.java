package lotto.controller;

public class TotalWinningStatistics {
    public static String calculateCount(int[] result, int initialMoney) {
        int profit = totalProfit(result);
        return String.format("%.1f",initialMoney/profit*100);
    }

    public static int totalProfit(int[] result) {
        int total = 0;
        total = total + 5000*result[0];
        total = total + 50000*result[1];
        total = total + 1500000*result[2];
        total = total + 30000000*result[3];
        total = total + 2000000000*result[4];
        return total;
    }
}
