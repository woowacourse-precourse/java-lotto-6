package lotto.common.validator;

public class StringValidator {

    public static void validateInteger(String literal) {
        if (!isInteger(literal)) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private static boolean isInteger(String literal) {
        try {
            Integer.parseInt(literal);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
