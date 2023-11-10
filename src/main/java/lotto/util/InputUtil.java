package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputUtil {

    private InputUtil() {

    }

    public static List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
