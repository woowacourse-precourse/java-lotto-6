package lotto.exceptions;

import lotto.constants.StringConstants;

public class InvalidNumberException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return String.format(StringConstants.ERROR_FORMAT_MESSAGE.toString(), "올바르지 않은 숫자입니다");
    }
}
