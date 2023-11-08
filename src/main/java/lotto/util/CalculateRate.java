package lotto.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculateRate {
    public static Double getRate(int purchaseAmount, int money) {
        double result = (double) money / purchaseAmount * 100;
        String rate = formatNumberWithComma(result);
        Double resultRate = Double.parseDouble(rate);
        return resultRate;
    }

    private static String formatNumberWithComma(double number) {
        NumberFormat format = new DecimalFormat("#,###.0#");
        return format.format(number);
    }
}
