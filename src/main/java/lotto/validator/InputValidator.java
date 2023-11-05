package lotto.validator;

import lotto.exception.EmptyInputException;
import lotto.exception.NotDividedThousandException;
import lotto.exception.NotNumberException;

public class InputValidator {
    public static void validateInputIsEmpty(String input) {
        if (input.isBlank()) {
            throw new EmptyInputException();
        }
    }

    public static void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    public static void validateInputNumberIsNotDividedThousand(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new NotDividedThousandException();
        }
    }
}
