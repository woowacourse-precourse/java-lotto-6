package lotto.util.exception;

import lotto.util.Constants;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {
    private static final String message =
            "로또 번호는 " + Constants.LOTTO_MIN_NUMBER + "부터 " + Constants.LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.";

    public InvalidLottoNumberRangeException() {
        super(message);
    }
}
