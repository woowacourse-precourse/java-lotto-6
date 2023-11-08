package lotto.validator;

public class NumberInputValidator implements InputValidator {

    private final static String ERROR_MESSAGE_NOT_INTEGER = "정수만 입력해주세요.";
    private final static String ERROR_MESSAGE_OUT_OF_RANGE = "1 ~ 45 범위의 숫자만 입력해주세요.";

    private final static String INTEGER_PATTERN = "^\\d+$";
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;

    @Override
    public void validate(String input) {
        throwIfNotInteger(input);
        throwIfOutOfRange(input);
    }

    private void throwIfNotInteger(String input) {
        if (!input.matches(INTEGER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
        }
    }

    private void throwIfOutOfRange(String input) {
        int inputInt = parseInt(input);
        if (inputInt < MIN_RANGE || inputInt > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }
}
