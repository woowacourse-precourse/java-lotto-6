package view;

import camp.nextstep.edu.missionutils.Console;
import constants.ErrorMessage;

public class InputView {
    private static final String INPUT_DELIMITER = ",";

    public static String readLine() {
        String userInput = Console.readLine();
        validateBlankInput(userInput);
        return userInput;
    }

    public static String inputNaturalNumber() {
        String userInput = readLine();
        validateNaturalNumberInput(userInput);
        return userInput;
    }

    public static String inputAnswerLotto() {
        String userInput = readLine();
        validateAnswerLottoInput(userInput);
        return userInput;
    }

    private static void validateAnswerLottoInput(String input) {
        for (String token : input.split(INPUT_DELIMITER, -1)) {
            if (isNotNaturalNumber(token)) {
                throw new IllegalArgumentException(
                        String.format(ErrorMessage.INVALID_ANSWER_LOTTO_INPUT_ERROR.getMessage(), INPUT_DELIMITER));
            }
        }
    }

    private static void validateBlankInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_ERROR.getMessage());
        }
    }

    private static void validateNaturalNumberInput(final String userInput) {
        if (isNotNaturalNumber(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    private static boolean isNotNaturalNumber(final String userInput) {
        return !userInput.matches("\\d+");
    }
}
