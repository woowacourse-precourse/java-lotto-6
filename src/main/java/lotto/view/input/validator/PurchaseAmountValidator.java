package lotto.view.input.validator;

import lotto.exception.input.EmptyInputException;

import static lotto.view.input.parser.numberParser.parseInteger;
import static lotto.view.message.ValidationErrorMessage.INPUT_EMPTY;
import static lotto.view.message.ValidationErrorMessage.INPUT_NOT_INTEGER;

public class PurchaseAmountValidator {

    public void validate(String userInput) {
        validateNotEmpty(userInput);
        validateInteger(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new EmptyInputException(INPUT_EMPTY.getMessage());
        }
    }

    private void validateInteger(String userInput) {
        try {
            parseInteger(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NOT_INTEGER.getMessage());
        }
    }
}
