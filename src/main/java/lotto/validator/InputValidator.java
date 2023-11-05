package lotto.validator;

public class InputValidator {

    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static final String ERROR_NOT_NUMBER_MESSAGE = "[ERROR] 숫자가 아닌 입력입니다.";

    public static int validateNumber(String input) {
        if (input.matches(NUMBER_REGEX)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException(ERROR_NOT_NUMBER_MESSAGE);
    }
}