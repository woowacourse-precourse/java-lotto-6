package lotto.util.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.config.GameConfig;

public class InputUtil {

    private static final String SPLIT_REGEX = "\\s*" + GameConfig.LOTTO_NUMBER_INPUT_DELIMITER + "\\s*";

    private InputUtil() {
    }

    public static int readInt() {
        return parseToInteger(readLine());
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // TODO: custom 예외 만들기
        }
    }

    public static List<Integer> readIntegerList() {
        String input = readLine();
        validateDelimiter(input);
        return stringToIntegerList(input);
    }

    private static List<Integer> stringToIntegerList(String input) {
        try {
            return Stream.of(input.split(SPLIT_REGEX))
                    .filter(InputUtil::validateHasInput)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // TODO: custom 예외 만들기
        }
    }

    private static void validateDelimiter(String input) {
        if (!input.contains(GameConfig.LOTTO_NUMBER_INPUT_DELIMITER)) {
            throw new IllegalArgumentException(); // TODO: custom 예외 만들기
        }
    }

    private static String readLine() {
        String input = Console.readLine();
        validateHasInput(input);
        return input;
    }

    private static boolean validateHasInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(); // TODO: custom 예외 만들기
        }
        return true;
    }
}
