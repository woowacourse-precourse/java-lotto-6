package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exception.InputException;

public final class InputUtil {
    private static final String INTEGER_REGEX = "\\d+";

    private InputUtil() {
    }

    public static String readString() {
        String input = Console.readLine();
        validateString(input);
        return input;
    }

    public static String readNaturalNumber() {
        String input = readString();
        validateInteger(input);
        return input;
    }

    private static void validateString(String input) {
        if (isInvalidString(input)) {
            throw new InputException();
        }
    }

    private static boolean isInvalidString(String input) {
        return input == null || input.isBlank();
    }

    private static void validateInteger(String input) {
        if (!Pattern.matches(INTEGER_REGEX, input)) {
            throw new InputException();
        }
    }
}
