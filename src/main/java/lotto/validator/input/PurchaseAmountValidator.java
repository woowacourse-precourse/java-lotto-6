package lotto.validator.input;

import lotto.exception.input.EmptyInputException;

import static lotto.view.message.ValidationErrorMessage.INPUT_EMPTY;
import static lotto.view.message.ValidationErrorMessage.INPUT_NOT_INTEGER;

public class PurchaseAmountValidator {

    public int validateAndParse(String userInput) {
        validateNotEmpty(userInput);
        return validateAndParseInteger(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new EmptyInputException(INPUT_EMPTY.getMessage());
        }
    }

    private int validateAndParseInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NOT_INTEGER.getMessage());
        }
    }
}
