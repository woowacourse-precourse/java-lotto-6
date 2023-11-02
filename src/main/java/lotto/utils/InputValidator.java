package lotto.utils;

import static lotto.constants.ErrorConstants.ERROR_BLANK_INPUT;
import static lotto.constants.ErrorConstants.ERROR_NON_NUMBER_TYPE_INPUT;
import static lotto.constants.ErrorConstants.ERROR_NULL_INPUT;

import lotto.exception.InputException;

public class InputValidator {

    public static void nullCheck(String inputValue) {
        if (inputValue == null) {
            throw InputException.of(ERROR_NULL_INPUT);
        }
    }

    public static void blankCheck(String inputValue) {
        if (inputValue.isBlank()) {
            throw InputException.of(ERROR_BLANK_INPUT);
        }
    }

    public static int numberTypeCheck(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw InputException.of(ERROR_NON_NUMBER_TYPE_INPUT);
        }
    }
}
