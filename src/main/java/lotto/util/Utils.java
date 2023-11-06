package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력값이 null 일 수 없습니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력값은 빈 값일 수 없습니다.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 입력값은 숫자여야 합니다.";

    public static List<String> splitByComma(String input) {
        validateHasInput(input);
        return List.of(removeSpace(input).split(Regex.COMMA.regex));
    }

    public static void validateHasInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }

        if (input.isBlank()) { // "", " " : true
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    public static String removeSpace(String input) {
        return input.replaceAll(Regex.SPACE.regex, Regex.NO_SPACE.regex);
    }

    public static int parseInt(String input) {
        validateStringIsNumber(input);
        return Integer.parseInt(input);
    }

    public static void validateStringIsNumber(String input) {
        validateHasInput(input);
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private enum Regex {
        COMMA(","), SPACE(" "), NO_SPACE("");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }
}
