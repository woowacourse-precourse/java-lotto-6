package lotto.utils;

import lotto.constants.ExceptionMessages;

public class InputValidator {
    public String preprocessUserInput(String userInput) {
        if (isNull(userInput)) {
            ExceptionMessages.NULL_INPUT.throwException();
        }
        if (isEmpty(userInput)) {
            ExceptionMessages.EMPTY_INPUT.throwException();
        }
        String preprocessedInput = removeSpacing(userInput);
        isNonNumeric(preprocessedInput);
        return preprocessedInput;
    }

    public int convertInputToPaymentAmount(String preprocessedInput) {
        return castStringToInt(preprocessedInput);
    }

    private int castStringToInt(String preprocessedInput) {
        return Integer.parseInt(preprocessedInput);
    }

    private boolean isNull(String userInput) {
        return userInput == null;
    }

    private boolean isEmpty(String userInput) {
        return userInput.isEmpty();
    }

    private void isNonNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            ExceptionMessages.NOT_NUMERIC_INPUT.throwException();
        }
    }

    private String removeSpacing(String userInput) {
        return userInput.replaceAll(" ", "");
    }
}
