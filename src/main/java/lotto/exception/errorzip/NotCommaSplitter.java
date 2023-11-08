package lotto.exception.errorzip;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class NotCommaSplitter extends CustomException {
    public NotCommaSplitter(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotCommaSplitter() {
        super(ErrorCode.NOT_COMMA_SPLITTER);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}