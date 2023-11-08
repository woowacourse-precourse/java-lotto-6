package lotto.system;

import java.util.List;

public class Util {
    private Util() {
    }

    public static float calculateYield(float after, float before) {
        return (after / before) * 100 - 100;
    }

    public static String makeIntegerListToStringFormat(List<Integer> target) {
        String result = target.toString();
        result = result.substring(1, result.length() - 1);
        result = result.replaceAll(" ", "");
        return result;
    }
}
