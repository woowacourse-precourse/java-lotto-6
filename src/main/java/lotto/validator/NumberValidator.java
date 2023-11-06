package lotto.validator;

public class NumberValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ERROR = "[ERROR] 로또 번호는 ";
    private static final String ERROR_BLANK = ERROR + "공백을 허용하지 않습니다.";
    private static final String ERROR_STRING = ERROR + "정수만 입력 가능합니다.";
    private static final String ERROR_MIN_MAX = ERROR + "최소 " + MIN_NUMBER + ", " + "최대 " + MAX_NUMBER + " 입니다.";

    private NumberValidator() {
    }

    ;

    public static void validate(String input) {
        validateBlankException(input);
        validateIntegerNumber(input);
        validateMinMaxNumber(input);
    }

    private static void validateBlankException(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateIntegerNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_STRING);
        }
    }

    private static void validateMinMaxNumber(String input) {
        int change_input = Integer.parseInt(input);
        if (change_input > MAX_NUMBER || change_input < MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_MIN_MAX);
        }
    }
}
