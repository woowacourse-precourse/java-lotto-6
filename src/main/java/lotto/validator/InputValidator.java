package lotto.validator;

import lotto.constant.ErrorMessage;

public class InputValidator {

    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.get());
        }
    }

    public static int validateNumber(String input) {
        if (input.matches(NUMBER_REGEX)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.get());
    }
}