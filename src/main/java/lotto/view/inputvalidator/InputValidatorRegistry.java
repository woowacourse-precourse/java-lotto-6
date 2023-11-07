package lotto.view.inputvalidator;

import static lotto.model.AppConstants.exceptionMessage.*;

public class InputValidatorRegistry {
    protected static void validateInputHasSpace(final String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(INPUT_MUST_NOT_CONTAINS_SPACE.message);
        }
    }
    protected static void validateInputContainsOnlyNumericAndComma(final String userInput) {
        if (!userInput.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
        }
    }

    protected static void validateEmptyCheck(final String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NOTNULL.message);
        }
    }

    protected static void validateNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_BE_FALSENESS.message);
        }
    }
    protected static void validate1000s(final String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_MUST_BE_1000s.message);
        }
    }

}
