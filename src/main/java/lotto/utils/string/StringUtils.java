package lotto.utils.string;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.Numbers;

public class StringUtils {

    private static final DecimalFormat THOUSANDS_FORMAT = new DecimalFormat("###,###");

    private StringUtils() {
    }

    public static List<String> splitStringByDelimiter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public static List<Integer> convertStringListToIntegerList(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static String convertIntegerToString(int number) {
        return THOUSANDS_FORMAT.format(number);
    }
}
