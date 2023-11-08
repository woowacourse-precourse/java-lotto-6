package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.constant.ExceptionMessage.*;

public class InputUtil {
    public static int inputNumber() {
        String input = Console.readLine();
        checkContainSpace(input);
        return stringToInt(input);
    }

    public static List<Integer> inputNumbers() {
        String input = Console.readLine();
        checkContainSpace(input);
        checkContainComma(input);
        return splitToInt(input);
    }

    public static List<Integer> splitToInt(String input) {
        List<String> split = List.of(input.split(","));
        return split.stream()
                .map(InputUtil::stringToInt)
                .toList();
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE.getMessage());
        }
    }

    public static void checkContainSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(INPUT_ERROR_SPACE_MESSAGE.getMessage());
        }
    }

    public static void checkContainComma(String name) {
        int length = name.length();
        char lastChar = name.charAt(length - 1);
        if (lastChar == ',') {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE.getMessage());
        }
    }
}
