package lotto.validation;

import lotto.constant.ExceptionConstant;

public class InputValidator {

    public void validateUserInput(String userInput) {
        if (isValidateNull(userInput)) {
            throw new NullPointerException(ExceptionConstant.INPUT_IS_ESSENTIAL.getMessage());
        }
        if (isValidateBlank(userInput)) {
            throw new IllegalArgumentException(ExceptionConstant.INPUT_IS_ESSENTIAL.getMessage());
        }
    }

    private boolean isValidateNull(String userInput) {
        return userInput == null;
    }

    private boolean isValidateBlank(String userInput) {
        return userInput.isBlank();
    }
}
