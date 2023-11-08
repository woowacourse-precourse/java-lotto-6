package lotto.exception;

import lotto.exception.constant.ErrorCode;

public class CustomException extends IllegalArgumentException{
    private final ErrorCode errorCode;
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
