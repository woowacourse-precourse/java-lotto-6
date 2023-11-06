package view;

import camp.nextstep.edu.missionutils.Console;
import constants.ErrorMessage;

public class InputView {
    public static String readLine() {
        String userInput = Console.readLine();
        validateBlankInput(userInput);
        return userInput;
    }

    public static String inputBonusCount() {
        String userInput = readLine();
        validateNumberInput(userInput);
        return userInput;
    }

    private static void validateBlankInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_ERROR.getMessage());
        }
    }

    private static void validateNumberInput(final String userInput) {
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    private static boolean isNotNumber(final String userInput) {
        return !userInput.matches("\\d+");
    }
}
