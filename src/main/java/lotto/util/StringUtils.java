package lotto.util;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> splitByCommaAndTrim(String input) {
        String[] numbers = input.split(",");
        List<String> splitNumbers = Arrays.stream(numbers).map(String::trim).collect(toList());
        return splitNumbers;
    }

    public static int stringToInt(String number) {
        return Integer.parseInt(number.replaceAll(",", ""));
    }
}
