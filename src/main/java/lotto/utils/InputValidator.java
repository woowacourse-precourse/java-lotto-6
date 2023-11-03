package lotto.utils;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String REGEXP_NUMBER = "^[0-9]*$";

    public static void validateIsNumber(String input) {
        if (!Pattern.matches(REGEXP_NUMBER, input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateIsAllNumber(String[] inputs) {
        for (String input : inputs) {
            validateIsNumber(input);
        }
    }
}
