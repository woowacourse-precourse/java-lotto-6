package lotto.util;

import lotto.config.Constant;

import java.text.NumberFormat;
import java.util.List;

public class Util {
    public static int distinctListSize(List<?> temp) {
        return (int) temp.stream()
                .distinct()
                .count();
    }

    public static double round(double number) {
        final double roundPosition = Math.pow(Constant.TEN, Constant.ROUND_POSITION);
        return Math.round(number * Constant.PERCENTAGE * roundPosition) / roundPosition;
    }

    public static String formattingNumber(double number) {
        return NumberFormat
                .getInstance()
                .format(number);
    }
}
