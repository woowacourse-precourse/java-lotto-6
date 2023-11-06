package lotto.exception;

import lotto.exception.lottoamount.LottoAmountInputException;

public class BlankInputException extends LottoDefualtException {
    public BlankInputException() {
        super("[ERROR] 입력값이 비어있습니다.");
    }
}
