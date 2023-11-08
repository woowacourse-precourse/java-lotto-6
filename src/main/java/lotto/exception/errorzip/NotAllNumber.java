package lotto.exception.errorzip;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class NotAllNumber extends CustomException {
    public NotAllNumber(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotAllNumber() {
        super(ErrorCode.NOT_ALL_NUMBER);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}
