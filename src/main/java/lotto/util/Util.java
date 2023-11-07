package lotto.util;

import java.util.List;

public class Util {
    public static int distinctListSize(List<?> temp) {
        return (int) temp.stream()
                .distinct()
                .count();
    }

    public static double round(double number, int unit, int position) {
        return Math.round(number * unit) / Math.pow(10, position);
    }
}
