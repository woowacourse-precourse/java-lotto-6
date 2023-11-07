package lotto.validation;

import lotto.exception.IncludeCharException;
import lotto.exception.InputBlankException;

public class CommonValidator {
    protected static void checkBlank(String readline) {
        if (readline == null || readline.isBlank()) {
            throw InputBlankException.inputBlankException;
        }
    }

    protected static void checkDigit(String readLine) {
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i))) {
                throw IncludeCharException.includeCharException;
            }
        }
    }
}
