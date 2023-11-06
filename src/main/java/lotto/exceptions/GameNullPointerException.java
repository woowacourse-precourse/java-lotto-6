package lotto.exceptions;

import lotto.constants.StringConstants;

public class GameNullPointerException extends NullPointerException{
    @Override
    public String getMessage() {
        return String.format(StringConstants.ERROR_FORMAT_MESSAGE.toString(), "invalid game value");
    }
}
