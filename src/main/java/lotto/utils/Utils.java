package lotto.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    private Utils() {}

    public static String getFormattedMoney(int money) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        return formatter.format(money);
    }

    public static String getPercentage(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(LottoMessages.DIVIDE_BY_ZERO.getKr());
        }

        double result = (double) a / b;
        result = Math.round(result * 10000) / 100.0;

        String percentage = String.format("%.2f%%", result);
        if(percentage.endsWith("0%")) {
            percentage = percentage.replace("0%", "%");
        }

        return percentage;
    }
}
