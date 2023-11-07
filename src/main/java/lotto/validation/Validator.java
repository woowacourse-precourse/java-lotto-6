package lotto.validation;

public class Validator {
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력은 null이 될 수 없습니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력은 빈 문자열이 될 수 없습니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수는 입력할 수 없습니다.";
    private static final String NOT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 1,000으로 나누어 떨어지는 숫자만 입력할 수 있습니다.";

    private Validator() {
    }

    public static void validatePurchasePrice(String input) {
        checkNull(input);
        checkBlank(input);
        checkNumeric(input);
        checkNegative(input);
        checkDivisibility(input);
    }

    public static void validateLotto(String input) {

    }

    public static void validateBonusNumber(String input) {

    }

    private static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void checkBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private static void checkNegative(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    private static void checkDivisibility(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_ERROR_MESSAGE);
        }
    }
}
