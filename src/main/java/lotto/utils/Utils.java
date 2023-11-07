package lotto.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    private Utils() {}

    public static String getFormattedMoney(int money) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        return formatter.format(money);
    }
}
