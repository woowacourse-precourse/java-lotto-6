package common.exception;

import common.enumtype.ErrorCode;

public class InvalidArgumentException extends IllegalArgumentException {

    public InvalidArgumentException(ErrorCode code) {
        super(code.getMessage());
    }
}
