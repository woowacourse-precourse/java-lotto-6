package lotto.view.exception;

import lotto.global.ErrorCode;

public class InputException extends IllegalArgumentException{
    public InputException(ErrorCode errorCode){
        super(errorCode.getMessage());
    }
}
