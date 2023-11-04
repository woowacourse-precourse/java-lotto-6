package lotto.validation;

import lotto.exception.InvalidNumberFormatException;

public class ValidateNumberFormat {
    public static void validate(String inputValue) {
        if (!inputValue.matches("^[0-9]+$")) {
            throw new InvalidNumberFormatException();
        }
    }
}
