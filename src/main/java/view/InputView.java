package view;

import camp.nextstep.edu.missionutils.Console;
import constants.ErrorMessage;

public class InputView {
    public static String readLine() {
        String userInput = Console.readLine();
        validateBlankInput(userInput);
        return userInput;
    }

    private static void validateBlankInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_ERROR.getMessage());
        }
    }
}
