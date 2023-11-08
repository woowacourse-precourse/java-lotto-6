package lotto.util;

import lotto.exception.BlankInputException;
import lotto.exception.InvalidNumberException;

public class Validator {

    public static void validateInputEmpty(String input) {
        if (input.isBlank()) {
            throw new BlankInputException();
        }
    }

    public static int validateNumeric(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException();
        }
    }
}
