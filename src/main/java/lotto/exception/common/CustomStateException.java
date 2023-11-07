package lotto.exception.common;

import lotto.exception.ExceptionMessageUtil;

public class CustomStateException extends IllegalStateException {

    public CustomStateException(String message) {
        super(ExceptionMessageUtil.getErrorMessage(message));
    }
}
