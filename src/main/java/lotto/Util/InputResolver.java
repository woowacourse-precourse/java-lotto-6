package lotto.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputResolver {
    private InputResolver() {
    }

    public static int toInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntegerList(String[] input) {
        return Arrays.stream(input).map(token -> Integer.parseInt(token)).collect(Collectors.toList());
    }
}
