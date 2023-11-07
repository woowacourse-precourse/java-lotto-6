package lotto.exception.common;

import lotto.exception.ExceptionMessageUtil;

public class CustomArgumentException extends IllegalArgumentException {

    public CustomArgumentException(String message) {
        super(ExceptionMessageUtil.getErrorMessage(message));
    }
}
