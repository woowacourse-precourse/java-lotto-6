package lotto.util;

import java.text.DecimalFormat;

public final class Utils {

    private static final String DECIMAL_FORMAT = "#,###";
    private static final String DOUBLE_FORMAT = ".0";

    private Utils() {
    }

    public static String changeDecimalFormat(long target) {
        DecimalFormat decFormat = new DecimalFormat(DECIMAL_FORMAT);

        return decFormat.format(target);
    }

    public static String changeDoubleFormat(double target) {
        DecimalFormat decFormat = new DecimalFormat(DECIMAL_FORMAT + DOUBLE_FORMAT);

        return decFormat.format(target);
    }

    public static double calculateRateOfReturn(double earned, double spend) {
        return earned * 100 / spend;
    }
}
