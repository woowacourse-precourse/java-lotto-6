package common.exception;

import common.enumtype.ErrorCode;

public class InvalidStatementException extends IllegalStateException {

    public InvalidStatementException(ErrorCode code) {
        super(code.getMessage());
    }
}
