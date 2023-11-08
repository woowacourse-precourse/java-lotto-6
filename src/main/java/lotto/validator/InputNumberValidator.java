package lotto.validator;

public class InputNumberValidator {
    private InputNumberValidator() {
    }

    public static void validate(final String input) {
        int number = validateNumber(input);
        validatePositiveInteger(number);
    }

    private static int validateNumber(String payment) {
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

    }

    private static void validatePositiveInteger(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
    }
}
