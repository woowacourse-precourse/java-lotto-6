package lotto.util;

import java.util.List;

public class Converter {
    private Converter() {
    }

    public static List<Integer> convertToInt(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}
