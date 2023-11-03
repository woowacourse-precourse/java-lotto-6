package lotto.utils;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String REGEXP_NUMBER = "^[0-9]*$";

    public static void validateIsNumber(String input) {
        if (!Pattern.matches(REGEXP_NUMBER, input)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }
}
