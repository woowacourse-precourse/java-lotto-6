package lotto.util;

import java.text.DecimalFormat;

public class Util {
    public static final int LOTTO_PRICE = 1000;
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    public static final int LOTTO_SIZE = 6;

    public static String formatCurrency(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        return decimalFormat.format(amount);
    }
}
