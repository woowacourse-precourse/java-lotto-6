package lotto.util;

import java.text.DecimalFormat;
import java.util.List;

public final class Utils {
    public static String formatIntegerListToString(final List<Integer> target) {
        return target.toString()
                .replaceAll("[\\[\\] ]", "");
    }

    public static float calculateYield(final float after, final float before) {
        return (after / before) * 100;
    }

    public static String makeFloatFormatted(final float value, final int precision) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String rounded = String.format("%." + precision + "f", value);
        return formatter.format(Float.parseFloat(rounded));
    }
}
