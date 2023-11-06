package lotto.model.exception;

import lotto.global.ErrorCode;

public class LottoTicketNumberException extends IllegalArgumentException{
    public LottoTicketNumberException(ErrorCode errorCode){
        super(errorCode.getMessage());
    }
}
