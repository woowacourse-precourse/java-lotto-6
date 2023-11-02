package lotto.validation;

import lotto.constant.ExceptionConstant;

public class InputValidator {

    public void validateUserInput(String userInput) {
        if (isValidateBlank(userInput)) {
            throw new IllegalArgumentException(ExceptionConstant.INPUT_IS_ESSENTIAL.getMessage());
        }
    }
    private boolean isValidateBlank(String userInput) {
        return userInput.isBlank();
    }
}
