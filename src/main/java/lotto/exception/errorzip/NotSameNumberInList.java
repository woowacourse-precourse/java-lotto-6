package lotto.exception.errorzip;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class NotSameNumberInList extends CustomException {
    public NotSameNumberInList(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotSameNumberInList(){
        super(ErrorCode.NOT_SAME_NUMBER_IN_LIST);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}
