package lotto.validator;

import lotto.view.Output;

public class InputValidator {

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Output.printErrorMessage(Errors.NOT_INTEGER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isInteger(String[] inputs) {
        try {
            for (int i = 0; i < inputs.length; i++) {
                Integer.parseInt(inputs[i]);
            }
        } catch (NumberFormatException e) {
            Output.printErrorMessage(Errors.NOT_INTEGER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isNull(String input) {
        if (input == null) {
            Output.printErrorMessage(Errors.NULL.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isNull(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == null) {
                Output.printErrorMessage(Errors.NULL.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }
}
