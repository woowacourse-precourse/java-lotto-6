package lotto;

import org.junit.platform.commons.util.StringUtils;

public class Validator {

    public static void validateIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException();
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