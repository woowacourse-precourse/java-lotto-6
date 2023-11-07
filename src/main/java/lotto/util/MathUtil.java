package lotto.util;

public class MathUtil {
    private MathUtil() {
    }

    public static String formatPercentage(int money, double profit) {
        double roundedProfit = profit / money * 100.0;
        return String.format("%,.1f%%", roundedProfit);
    }
}
