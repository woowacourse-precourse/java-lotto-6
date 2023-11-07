package lotto.util;

import java.util.Arrays;
import java.util.List;

public class StringHandler {
    public static List<Integer> separatedWith(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .map(StringHandler::stringToInt)
                .sorted()
                .toList();
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
