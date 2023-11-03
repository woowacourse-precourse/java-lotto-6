package lotto.view;

import static lotto.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exception.InputException;

public final class InputUtil {

    private InputUtil() {}

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
        if (input == null || input.isBlank()) {
            throw new InputException();
        }
    }

    private static void validateInteger(String input) {
        if (!Pattern.matches("\\d+", input)) {
            throw new InputException();
        }
    }
}
