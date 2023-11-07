package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHandler {
    public static List<Integer> separatedWith(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .map(StringHandler::stringToInt)
                .sorted()
                .toList();
    }

    public static String joinBy(List<Integer> input, String splitter) {
        return input.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(splitter));
    }

    public static int stringToInt(String input) {
        try {
            int output = Integer.parseInt(input);
            return output;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해야합니다");
        }
    }
}
