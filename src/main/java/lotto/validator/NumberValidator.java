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

    public static int validate(String input) {
        validateBlankException(input);
        int change_integer_input = validateIntegerNumber(input);
        validateMinMaxNumber(change_integer_input);
        return change_integer_input;
    }

    private static void validateBlankException(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static int validateIntegerNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_STRING);
        }
    }

    private static void validateMinMaxNumber(int input) {
        if (input > MAX_NUMBER || input < MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_MIN_MAX);
        }
    }
}
