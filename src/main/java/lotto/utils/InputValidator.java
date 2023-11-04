package lotto.utils;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_NUMBER = "숫자를 입력해주세요";
    private static final String BLANK = "입력이 공백입니다.";
    private static final int PRICE = 1000;
    private static final String INVALID_PRICE = "1000원 단위의 수를 입력해주세요.";
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("^[1-9]*$");

    public static void checkIsNumber(String input) {
        if (!NOT_NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR+NOT_NUMBER);
        }
    }

    public static void checkIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR+BLANK);
        }
    }

    public static void checkPrice(String input) {
        if (Integer.parseInt(input) % PRICE != 0) {
            throw new IllegalArgumentException(ERROR+INVALID_PRICE);
        }
    }

}
