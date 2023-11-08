package lotto.exception.errorzip;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class NotSameNumberInGroup extends CustomException {
    public NotSameNumberInGroup(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotSameNumberInGroup(){
        super(ErrorCode.NOT_SAME_NUMBER_IN_GROUP);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}
