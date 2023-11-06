package lotto.validator;

public class AmountInputValidator implements InputValidator {

    private final static String ERROR_MESSAGE_NOT_DIVIDED_BY_1000 = "1000 단위로 입력해주세요.";
    private final static String ERROR_MESSAGE_NOT_INTEGER = "(양의) 정수만 입력해주세요.";
    private final static String ERROR_MESSAGE_NOT_INTEGER_RANGE = "Integer 범위 내에서 입력해주세요.";

    private final static String INTEGER_PATTERN = "^\\d+$";
    private final static int DIVISOR_FOR_THOUSAND = 1000;

    @Override
    public void validate(String input) {
        throwIfNotInteger(input);
        throwIfNotDividedBy1000(input);
    }

    private void throwIfNotDividedBy1000(String input) {
        int inputInteger = parseInt(input);
        if (inputInteger % DIVISOR_FOR_THOUSAND != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIVIDED_BY_1000);
        }
    }

    private void throwIfNotInteger(String input) {
        if (!input.matches(INTEGER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER_RANGE);
        }
    }
}
