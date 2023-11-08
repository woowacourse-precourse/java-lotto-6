package lotto.util;

public class ValidationUtils {

    public static void validateNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }
}
