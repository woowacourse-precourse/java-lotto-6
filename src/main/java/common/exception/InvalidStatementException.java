package common.exception;

import common.ErrorCode;

public class InvalidStatementException extends IllegalStateException {

    public InvalidStatementException(ErrorCode code) {
        super(code.getMessage());
    }
}
