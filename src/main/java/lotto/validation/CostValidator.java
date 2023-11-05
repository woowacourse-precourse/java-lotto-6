package lotto.validation;

import lotto.exception.InputBlankException;

public class CostValidator {
    public static void validate(String readline) {
        checkBlank(readline);
    }

    private static void checkBlank(String readline) {
        if (readline.isBlank()) {
            throw InputBlankException.inputBlankException;
        }
    }
}
