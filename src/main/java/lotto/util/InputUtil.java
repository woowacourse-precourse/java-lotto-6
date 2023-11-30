package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputUtil {
    private InputUtil() {
    }

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseNums(List<String> splitInput) {
        return splitInput.stream()
                    .map(InputUtil::parseInt)
                    .toList();
    }

    public static List<String> splitInput(String input) {
        String[] strings = input.split(",");
        return Arrays.stream(strings).toList();
    }

}
