package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.system.ExceptionMessage;
import lotto.system.RegexConstant;
import lotto.system.SystemMessage;

public class InputView {
    public static long readLong() {
        String userInput = Console.readLine();
        validate(userInput);
        return Long.parseLong(userInput);
    }

    public static List<Integer> readIntegerList() {
        List<String> userInput = Arrays.stream(Console.readLine()
                        .split(SystemMessage.NUMBER_SEPARATOR.getMessage()))
                .toList();

        userInput.forEach(InputView::validate);
        return userInput.stream()
                .map(Integer::valueOf)
                .toList();
    }

    public static int readInt() {
        String userInput = Console.readLine();
        validate(userInput);
        return Integer.parseInt(userInput);
    }

    private static void validate(String userInput) {
        validateEmpty(userInput);
        validateNumeric(userInput);
    }

    private static void validateNumeric(String userInput) {
        if (!Pattern.matches(RegexConstant.INPUT_PATTERN.getRegex(), userInput)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC.getMessage());
        }
    }

    private static void validateEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalStateException(ExceptionMessage.EMPTY.getMessage());
        }
    }
}
