package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static final int stringToInt(final String number) {
        return Integer.parseInt(number);
    }

    public static final List<Integer> stringToIntegerSortedList(final String inputString) {
        String[] splitString = inputString.split(",", -1);
        return arrayToSortedList(splitString);
    }

    private static List<Integer> arrayToSortedList(final String[] numbers) {
        return Arrays.stream(numbers).map(string -> Integer.parseInt(string)).sorted().toList();
    }

    public static final float getRoundUpTwoDecimalPlace(float returnRate) {
        return Math.round(returnRate * 100f) / 100f;
    }
}
