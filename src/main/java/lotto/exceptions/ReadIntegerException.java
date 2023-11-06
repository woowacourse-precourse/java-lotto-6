package lotto.exceptions;

import lotto.constants.StringConstants;

public class ReadIntegerException extends NumberFormatException{
    @Override
    public String getMessage() {
        return String.format(StringConstants.ERROR_FORMAT_MESSAGE.toString(), "invalid lotto number");
    }
}
