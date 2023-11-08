package lotto.util;

import static lotto.util.UtilErrorMessages.*;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_PATTERN = "^\\d+(,\\d+)+$";

    public static void validateWinningNumbers(String input) {
        String sanitizedInput = input.trim().replaceAll("\\s", "");
        if (!Pattern.matches(NUMBER_PATTERN, sanitizedInput)) {
            throw new IllegalArgumentException(INVALID_FORMAT_MESSAGE.getMessage());
        }
    }

}
