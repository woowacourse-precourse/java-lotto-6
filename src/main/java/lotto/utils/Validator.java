package lotto.utils;

import org.junit.platform.commons.util.StringUtils;

public class Validator {

    private enum ErrorMessage {
        BLANK_OR_WHITE_SPACE("[ERROR] 빈값 혹은 공백입니다. 올바른 값을 입력해주세요."),
        NOT_INTEGER("[ERROR] 양의 정수만 입력해주세요");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    public static void validateIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_OR_WHITE_SPACE.message);
        }
    }

    public static void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.message);
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}