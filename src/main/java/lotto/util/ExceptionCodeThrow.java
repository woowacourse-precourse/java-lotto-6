package lotto.util;

import lotto.enumerate.ErrorCode;

public class ExceptionCodeThrow {
    public static void exceptionCodeThrow(ErrorCode errorCode) {
        String message;
        message = errorCode.getMessage();
        throw new IllegalArgumentException(message);
    }
}
