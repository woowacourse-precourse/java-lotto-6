package lotto.exception;

import lotto.constants.Constants;

public class InvalidLottoLengthException extends IllegalArgumentException {

    private static final String message = String.format(
            "로또 번호는 지정된 개수만큼 입력해야 합니다. (지정된 개수 : %d)",
            Constants.LOTTO_LENGTH);

    public InvalidLottoLengthException() {
        super(message);
    }
}