package lotto.exception.errorzip;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class NotSizeOfList extends CustomException {
    public NotSizeOfList(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotSizeOfList(){
        super(ErrorCode.NOT_SIX_SIZE_OF_LIST);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}
