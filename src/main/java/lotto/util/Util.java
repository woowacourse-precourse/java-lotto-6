package lotto.util;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public final class Util {
    private Util() {
    }

    public static String makeIntegerListToStringFormat(List<Integer> target) {
        return target.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    public static float calculateYield(float beforeMoney, float totalMoney) {
        return (totalMoney) / beforeMoney * 100 - 100;
    }

    public static String makeFloatFormattedYield(float target, int precision) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String rounded = String.format("%." + precision + "f", target);
        return formatter.format(Float.parseFloat(rounded));
    }
}
