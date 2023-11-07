package lotto.view.inputvalidator;

import static lotto.exception.ExceptionMessage.*;

public class InputValidatorRegistry {
    protected static void validateInputHasSpace(final String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(INPUT_MUST_NOT_CONTAINS_SPACE.message);
        }
    }
    protected static void validateInputContainsOnlyNumericAndComma(final String userInput) {
        if (!userInput.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException("입력은 숫자와 쉼표(,) 이외에 다른 문자가 포함되어서는 안 됩니다.");
        }
    }

    protected static void validateEmptyCheck(final String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력은 null이 될 수 없습니다.");
        }
    }

    protected static void validateNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
        }
    }

}
