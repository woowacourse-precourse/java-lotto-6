package lotto.util;

import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public static final int stringToInt(final String number) {
        return Integer.parseInt(number);
    }

    public static final List<Integer> stringToIntegerSortedList(final String inputString) {
        String[] splitString = inputString.split(",", -1);
        return Arrays.stream(splitString).map(string -> Integer.parseInt(string)).sorted().toList();
    }
}
