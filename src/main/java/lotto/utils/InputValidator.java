package lotto.utils;

import lotto.utils.message.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {

    public static void validateIsNumber(String input) {
        if (!Pattern.matches(Constants.REGEXP_NUMBER, input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }
    }

    public static void validateIsAllNumber(String[] inputs) {
        for (String input : inputs) {
            validateIsNumber(input);
        }
    }
}
