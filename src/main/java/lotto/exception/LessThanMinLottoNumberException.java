package lotto.exception;

import static lotto.constant.ErrorMessage.LOWER_THAN_MIN_LOTTO_NUMBER_ERROR_MESSAGE;

public class LessThanMinLottoNumberException extends IllegalArgumentException {

    public LessThanMinLottoNumberException() {
        super(LOWER_THAN_MIN_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
