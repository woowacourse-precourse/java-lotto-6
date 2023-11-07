package lotto.exception;

import lotto.constants.Constants;

public class InvalidWinningLottoFormatException extends IllegalArgumentException{
    private static final String message = String.format(
            "당첨 번호 형식이 올바르지 않습니다. (올바른 형식 : 정수 %d개, 각 정수 사이에는 구분자(%s)가 위치)",
            Constants.LOTTO_LENGTH,
            Constants.DELIMITER
            );

    public InvalidWinningLottoFormatException() {
        super(message);
    }
}