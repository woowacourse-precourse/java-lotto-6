package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ParseIntException;
import org.w3c.dom.ls.LSOutput;

public class InputUtil {
    private InputUtil() {
    }

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseNums(String input) {
        List<String> splitInput = splitInput(input);
        return splitInput.stream()
                    .map(InputUtil::parseInt)
                    .toList();
    }

    public static List<String> splitInput(String input) {
        String[] strings = input.split(",");
        return Arrays.stream(strings).toList();
    }

}
