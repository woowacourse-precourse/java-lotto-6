package lotto.domain;

import lotto.constant.ErrorMessage;

public class InputValidation {
    public static int checkNumber(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
        }
        return result;
    }
}
