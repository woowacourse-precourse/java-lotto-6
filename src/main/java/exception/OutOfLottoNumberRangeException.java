package exception;

import constants.Constants;

public class OutOfLottoNumberRangeException extends IllegalArgumentException {

    private static final String message = String.format(
            "로또 번호는 지정된 범위를 벗어날 수 없습니다. (지정된 범위 : %d~%d)",
            Constants.LOTTO_RANGE_START,
            Constants.LOTTO_RANGE_END);

    public OutOfLottoNumberRangeException() {
        super(message);
    }
}