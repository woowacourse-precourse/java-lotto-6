package lotto.util.exception;

import lotto.util.Constants;

public class InvalidLottoLengthException extends IllegalArgumentException {
    private static final String message = "로또 번호는 길이가 " + Constants.LOTTO_NUMBER_LENGTH + "자리여야 합니다.";

    public InvalidLottoLengthException() {
        super(message);
    }
}
