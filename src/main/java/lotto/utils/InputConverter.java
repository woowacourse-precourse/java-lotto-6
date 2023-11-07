package lotto.utils;

import java.util.List;

public class InputConverter {

    public static int convertToNumber(String value) {
        return Integer.parseInt(value);
    }

    public static List<Integer> convertToNumbers(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
