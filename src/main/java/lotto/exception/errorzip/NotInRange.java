package lotto.exception.errorzip;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class NotInRange extends CustomException {
    public NotInRange(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotInRange() {
        super(ErrorCode.NOT_IN_RANGE);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}
