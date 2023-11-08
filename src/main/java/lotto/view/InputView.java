package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;

public class InputView {
    private static final String INPUT_DELIMITER = ",";
    private static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "\\d+";

    public static String readLine() {
        String userInput = Console.readLine();
        validateBlankInput(userInput);
        return userInput;
    }

    public static String inputNaturalNumber() {
        while (true) {
            try {
                String userInput = readLine();
                validateNaturalNumberInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputAnswerLotto() {
        while (true) {
            try {
                String userInput = readLine();
                validateAnswerLottoInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
        return !userInput.matches(NATURAL_NUMBER_REGULAR_EXPRESSION);
    }
}
