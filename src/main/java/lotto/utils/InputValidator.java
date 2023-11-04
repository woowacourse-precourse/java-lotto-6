package lotto.utils;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_NUMBER = "숫자를 입력해주세요";
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("^[1-9]*$");

    public static void checkIsNumber(String input) {
        if (!NOT_NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR+NOT_NUMBER);
        }
    }

}
