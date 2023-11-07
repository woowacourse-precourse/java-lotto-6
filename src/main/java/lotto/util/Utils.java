package lotto.util;

import static lotto.util.Validator.validateNumber;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static final int stringToInt(final String number) {
        validateNumber(number);
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
        return Math.round(returnRate * 10f) / 10f;
    }
}
