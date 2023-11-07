package utils;

import type.ErrorType;

public class Parser {
    public static int convertNumberInput(String input) {
        if (input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_INPUT.getText());
        }
        return Integer.parseInt(input);
    }
}
