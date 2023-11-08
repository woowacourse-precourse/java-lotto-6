package lotto.input;

import static lotto.constants.Error.EMPTY_ERROR;
import static lotto.constants.Error.FORMAT_ERROR;
import static lotto.constants.Error.NOT_NUMBER_ERROR;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputHandler {
    private static final String INTEGER_REG = "\\d+";
    private static final String NUMBER_COMMA_REG = "\\d{1,2}(,\\d{1,2})*";

    private InputHandler() {
    }

    public static int parseInputNumber(String input) {
        validateNotEmpty(input);
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> parseInputNumbers(String input) {
        List<Integer> numbers;
        validateNotEmpty(input);
        validateFormat(input);
        numbers = splitInputByComma(input);
        return numbers;
    }

    private static List<Integer> splitInputByComma(String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    private static void validateFormat(String input) {
        if (!Pattern.matches(NUMBER_COMMA_REG, input)) {
            throw new IllegalArgumentException(FORMAT_ERROR.getMessage());
        }
    }

    private static void validateIsNumber(String input) {
        if (!Pattern.matches(INTEGER_REG, input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    private static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR.getMessage());
        }
    }
}
