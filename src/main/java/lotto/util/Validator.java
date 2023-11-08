package lotto.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String INVALID_INPUT_TYPE = "[ERROR] 입력은 숫자여야 합니다.";
    private static final String MONEY_MUST_NOT_NEGATIVE = "[ERROR] 금액은 음수일 수 없습니다.";
    private static final String INVALID_INPUT_PATTERN = "[ERROR] 입력 형식과 맞지 않습니다.";

    private Validator() {
        throw new IllegalArgumentException("[ERROR]");
    }

    public static void validateInput(String input) {
        validateInputType(input);
        validateInputRange(input);
    }

    private static void validateInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE);
        }
    }

    private static void validateInputRange(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(MONEY_MUST_NOT_NEGATIVE);
        }
    }

    public static void validateInputPattern(String input) {
        if (!INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN);
        }
    }
}
