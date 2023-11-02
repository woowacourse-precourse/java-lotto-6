package lotto.view.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exception.InputException;

public class InputUtil {

    public String readString() {
        String input = Console.readLine();
        validateString(input);
        return input;
    }

    public int readNaturalNumber() {
        String input = readString();
        validateInteger(input);
        return Integer.parseInt(input);
    }

    private void validateString(String input) {
        if (input == null || input.isBlank()) {
            throw new InputException();
        }
    }

    private void validateInteger(String input) {
        if (!Pattern.matches("\\d+", input)) {
            throw new InputException();
        }
    }
}
