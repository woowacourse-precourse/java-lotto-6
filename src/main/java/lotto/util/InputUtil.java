package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputUtil {
    public static int inputNumber() {
        String input = Console.readLine();
        return stringToInt(input);
    }

    public static List<Integer> inputNumbers() {
        String input = Console.readLine();
        return splitToInt(input);
    }

    public static List<Integer> splitToInt(String input) {
        List<String> split = List.of(input.split(","));
        return split.stream()
                .map(InputUtil::stringToInt)
                .toList();
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
