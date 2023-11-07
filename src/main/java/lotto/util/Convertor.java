package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Convertor {

    private Convertor() {
    }

    public static List<Integer> convertToIntegerList(final String strings) {
        String[] string = split(strings);
        return Arrays.stream(string)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static String[] split(final String strings) {
        return strings.split(",");
    }
}
