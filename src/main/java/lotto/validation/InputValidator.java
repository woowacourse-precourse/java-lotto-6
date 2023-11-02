package lotto.validation;

import java.util.regex.Pattern;
import lotto.constant.ExceptionConstant;

public class InputValidator {

    private static final Pattern INPUT_NUMBER_REGEX = Pattern.compile("[0-9]+");

    public void validateUserInput(String userInput) {
        if (isValidateNull(userInput)) {
            throw new NullPointerException(ExceptionConstant.INPUT_IS_ESSENTIAL.getMessage());
        }
        if (isValidateBlank(userInput)) {
            throw new IllegalArgumentException(ExceptionConstant.INPUT_IS_ESSENTIAL.getMessage());
        }
        if (!isValidatePurchaseNumber(userInput)) {
            throw new IllegalArgumentException(ExceptionConstant.INPUT_IS_NUMBER.getMessage());
        }
    }

    private boolean isValidateNull(String userInput) {
        return userInput == null;
    }

    private boolean isValidateBlank(String userInput) {
        return userInput.isBlank();
    }

    private boolean isValidatePurchaseNumber(String userInput) {
        return INPUT_NUMBER_REGEX.matcher(userInput).matches();
    }
}
