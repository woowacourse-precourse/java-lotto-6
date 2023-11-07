package lotto.validation;

import lotto.constant.ErrorMessage;

public class NumericInputValidation {


    public void validateInputIsNumeric(String input) {
        if (!input.matches("[-+]?\\d*")) {
            throw new IllegalArgumentException(ErrorMessage
                    .INPUT_ONLY_NUMBERS_ERROR_MESSAGE
                    .getMessage());
        }
    }


    public void validateInputIsNull(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage
                    .NULL_OR_EMPTY_INPUT_ERROR_MESSAGE
                    .getMessage());
        }
    }


}
