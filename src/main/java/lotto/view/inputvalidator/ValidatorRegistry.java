package lotto.view.inputvalidator;

import static lotto.exception.ExceptionMessage.priceInputExceptionMessage.*;

public abstract class ValidatorRegistry {

    abstract void validate(final String userInput);
    protected void validateInputHasSpace(final String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(INPUT_MUST_NOT_CONTAINS_SPACE.message);
        }
    }
    protected void validateInputIsNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
        }
    }

    protected void validateAmountIn1000s(final String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_MUST_BE_1000s.message);
        }
    }

}
