package lotto.validator;

import java.util.regex.Pattern;
import lotto.system.ExceptionMessage;
import lotto.system.RegexConstant;

public class InputValidator {
    public static void validate(String userInput) {
        validateNumeric(userInput);
        validateEmpty(userInput);
    }

    private static void validateNumeric(String userInput) {
        if (!Pattern.matches(RegexConstant.INPUT_PATTERN.getRegex(), userInput)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC.getMessage());
        }
    }

    private static void validateEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY.getMessage());
        }
    }
}
