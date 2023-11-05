package lotto.validator;

import java.util.regex.Pattern;
import lotto.system.ExceptionMessage;
import lotto.system.SystemMessage;

public class InputValidator {
    public static void validate(String userInput) {
        if (Pattern.matches(SystemMessage.INPUT_ANTI_PATTERN_REGEX.getMessage(), userInput)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC.getMessage());
        }
    }
}
