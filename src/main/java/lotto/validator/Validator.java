package lotto.validator;

import lotto.constant.ErrorMessage;

public class validator {
    public static void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage
                    .NOT_INT_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
