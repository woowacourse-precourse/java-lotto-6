package lotto.util;

public class InputValidator {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";
    private static final String UNDER_20_BILLION_REQUIRED = "입력은 20억 이하여야 합니다";
    private static final String NUMBER_REGEX = "[0-9]+";

    private void validateIsUnder20Billion(String input) {
        if (input.length() > 10) {
            throw new IllegalArgumentException(UNDER_20_BILLION_REQUIRED);
        }

        try {
            int number = Integer.parseInt(input);
            if (number > 2000000000) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UNDER_20_BILLION_REQUIRED);
        }
    }

    public void validateIsNumber(String input) {
        if (isNumber(input) == false) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }

        validateIsUnder20Billion(input);
    }

    private boolean isNumber(String inputPrice) {
        if (inputPrice.matches(NUMBER_REGEX)) {
            return true;
        }

        return false;
    }
}
