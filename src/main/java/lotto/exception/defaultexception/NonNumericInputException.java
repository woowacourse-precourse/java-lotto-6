package lotto.exception;

import lotto.exception.lottoamount.LottoAmountInputException;

public class NonNumericInputException extends LottoDefualtException {
    public NonNumericInputException() {
        super("[ERROR] 유효하지 않은 입력입니다. 숫자 형태를 입력해 주세요.");
    }
}
