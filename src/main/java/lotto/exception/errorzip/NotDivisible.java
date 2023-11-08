package lotto.exception.errorzip;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class NotDivisible extends CustomException {
    public NotDivisible(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotDivisible(){
        super(ErrorCode.NOT_DIVISIBLE_BY_1000);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}
