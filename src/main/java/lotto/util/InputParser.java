package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static List<String> parseStringList(String winNumber) {
        return Arrays.stream(winNumber.split(","))
                .collect(Collectors.toList());
    }

    public static List<Integer> parseIntegerList(String winNumber) {
        return Arrays.stream(winNumber.split(","))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
    }

    private InputParser() {
    }
}
