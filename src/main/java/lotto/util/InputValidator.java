package lotto.util;

public class InputValidator {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";
    private static final String NUMBER_REGEX = "[0-9]+";

    public void validateIsNumber(String input) {
        if (isNumber(input) == false) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }

    private boolean isNumber(String inputPrice) {
        if (inputPrice.matches(NUMBER_REGEX)) {
            return true;
        }

        return false;
    }
}
