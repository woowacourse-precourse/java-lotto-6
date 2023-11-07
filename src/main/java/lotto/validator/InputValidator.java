package lotto.validator;

import lotto.exception.ExceptionMessage;
import lotto.exception.input.HasSpaceException;
import lotto.exception.input.NotIntegerException;
import lotto.exception.input.NullInputException;

public class InputValidator {
    private static final String SPACE = " ";

    public static void validateInput(String input){
        validateNull(input);
        validateHasNoSpace(input);
        validateInteger(input);
    }

    private static void validateInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NotIntegerException();
        }
    }

    private static void validateNull(String input) {
        if (input == null || input.isBlank()) {
            throw new NullInputException();
        }
    }

    private static void validateHasNoSpace(String input) {
        if (input.contains(SPACE)) {
            throw new HasSpaceException();
        }
    }
}
