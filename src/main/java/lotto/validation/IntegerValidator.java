package lotto.validation;

import static lotto.messages.ErrorMessages.INVALID_INTEGER_MESSAGE;

import lotto.util.ExceptionUtil;
import lotto.util.IntegerUtil;

public class IntegerValidator {

    public static void validateInteger(String string) {
        if (!IntegerUtil.isInteger(string)) {
            ExceptionUtil.throwInvalidValueException(INVALID_INTEGER_MESSAGE.getMessage());
        }
    }
}
