package exception;

import consts.LottoConsts;

public class WrongLottoSizeException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "로또 번호는 " + LottoConsts.LOTTO_SIZE + "개여야 합니다.";

    public WrongLottoSizeException() {
        super(ERROR_MESSAGE);
    }
}
