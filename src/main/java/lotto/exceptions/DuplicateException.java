package lotto.exceptions;

import lotto.constants.StringConstants;

public class DuplicateException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return String.format(StringConstants.ERROR_FORMAT_MESSAGE.toString(), "중복된 값은 허용되지 않습니다");
    }
}
