package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public final class InputUtil {
    private InputUtil() {
    }

    public static String readString() {
        String input = Console.readLine();
        InputValidator.validateString(input);
        return input;
    }

    public static String readNaturalNumber() {
        String input = readString();
        InputValidator.validateInteger(input);
        return input;
    }
}
