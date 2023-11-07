package lotto.util;

import java.text.DecimalFormat;
import java.util.List;

public class Utils {
    public static String formatIntegerListToString(List<Integer> target) {
        return target.toString()
                .replaceAll("[\\[\\] ]", "");
    }

    public static float calculateYield(float after, float before) {
        return (after / before) * 100;
    }

    public static String makeFloatFormatted(float value, int precision) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String rounded = String.format("%." + precision + "f", value);
        return formatter.format(Float.parseFloat(rounded));
    }
}
