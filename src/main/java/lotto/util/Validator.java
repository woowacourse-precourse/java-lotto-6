package lotto.util;

import lotto.util.exception.BlankInputException;
import lotto.util.exception.InvalidNumberException;

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

    public static void validateDivisibleBy(int money, int divisor) {
        if (money % divisor != 0) {
            throw new IllegalArgumentException();
        }
    }
}
