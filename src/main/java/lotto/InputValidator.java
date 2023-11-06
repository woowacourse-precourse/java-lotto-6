package lotto;

import lotto.Constants.ErrorMessage;

public class InputValidator {

    public void checkInputDigit(String input) {
        if (isDigit(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MESSAGE.getMessage());
        }
    }

    public void checkInputBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK_MESSAGE.getMessage());
        }
    }

    public void checkInputEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY_MESSGAE.getMessage());
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isDigit(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (!Character.isDigit(input.charAt(index))) {
                return true;
            }
        }
        return false;
    }
}
