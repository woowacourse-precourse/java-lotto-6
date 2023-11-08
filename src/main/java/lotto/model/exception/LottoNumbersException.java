package lotto.model.exception;

import lotto.global.ErrorCode;

public class LottoNumbersException extends IllegalArgumentException{
    public LottoNumbersException(ErrorCode errorCode){
        super(errorCode.getMessage());
    }
}
