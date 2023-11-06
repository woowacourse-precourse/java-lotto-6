package lotto.exceptions;

import lotto.constants.StringConstants;

public class DuplicateException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return String.format(StringConstants.ERROR_FORMAT_MESSAGE.toString(), "duplicated value is not allowed on here");
    }
}
