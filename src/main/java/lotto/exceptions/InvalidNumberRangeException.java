package lotto.exceptions;

import lotto.constants.StringConstants;

public class InvalidNumberRangeException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return String.format(StringConstants.ERROR_FORMAT_MESSAGE.toString(), "invalid number range");
    }
}
