package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.Delimiter;

public class Convertor {

    private Convertor() {
    }

    public static int convertStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static long convertStringToLong(String value) {
        return Long.parseLong(value);
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(Convertor.splitByComma(input))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String[] splitByComma(String input) {
        return input.split(Delimiter.COMMA.getDelimiter());
    }
}
