package util.string.validator;

import lotto.exception.EmptyInputException;
import lotto.exception.EmptySpaceIncludeException;
import lotto.exception.ExceptionMessage;
import lotto.exception.NotIntegerInputException;

public class InputValidator {
    private static final String EMPTY_SPACE = " ";

    private InputValidator() {
    }

    public static void checkPriceInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkSpaceAndThrowException(input);
        checkIntegerInputAndThrowException(input);
    }

    private static void checkIntegerInputAndThrowException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerInputException(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }

    private static void checkEmptyAndThrowException(String input) {
        if (input.isEmpty()) {
            throw new EmptyInputException(ExceptionMessage.EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private static void checkSpaceAndThrowException(String input) {
        if (input.contains(EMPTY_SPACE)) {
            throw new EmptySpaceIncludeException(ExceptionMessage.EMPTY_SPACE_INCLUDE_ERROR.getMessage());
        }
    }
}
