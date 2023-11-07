package lotto.validator;

import lotto.view.Output;

public class InputValidator {

    private static final String ERROR_MESSAGE_NULL = "값을 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_INTEGER = "정수를 입력해주세요.";

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Output.printErrorMessage(ERROR_MESSAGE_NOT_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    public static void isInteger(String[] inputs) {
        try {
            for (int i = 0; i < inputs.length; i++) {
                Integer.parseInt(inputs[i]);
            }
        } catch (NumberFormatException e) {
            Output.printErrorMessage(ERROR_MESSAGE_NOT_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    public static void isNull(String input) {
        if (input == null) {
            Output.printErrorMessage(ERROR_MESSAGE_NULL);
            throw new IllegalArgumentException();
        }
    }

    public static void isNull(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == null) {
                Output.printErrorMessage(ERROR_MESSAGE_NULL);
                throw new IllegalArgumentException();
            }
        }

    }
}
