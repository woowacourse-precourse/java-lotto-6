package lotto;

import java.util.List;

public class Utils {

    public static String formatIntegerListToString(List<Integer> target) {
        return target.toString()
                .replaceAll("[\\[\\] ]", "");
    }

    public static float calculateYield(float after, float before) {
        return (after / before) * 100;
    }

}
