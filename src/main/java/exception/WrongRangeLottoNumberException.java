package exception;

import consts.LottoConsts;

public class WrongRangeLottoNumberException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "로또 번호는 " + LottoConsts.MIN_RANGE
            + " ~ " + LottoConsts.MAX_RANGE + " 사이의 숫자여야 합니다.";

    public WrongRangeLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
