package lotto.util;

public class InputValidator {
    public static final String REGEX = "[0-9]+";

    public static boolean isNumber(String inputValue) {
        return inputValue.matches(REGEX);
    }

    public static boolean isMultiple(int dividend, int divisor) {
        return dividend % divisor == 0;
    }

}
