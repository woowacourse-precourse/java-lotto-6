package common.exception;

import common.ErrorCode;

public class InvalidArgumentException extends IllegalArgumentException {

    public InvalidArgumentException(ErrorCode code) {
        super(code.getMessage());
    }
}
