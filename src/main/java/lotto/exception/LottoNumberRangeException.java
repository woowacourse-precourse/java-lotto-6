package lotto.exception;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

public class LottoNumberRangeException extends IllegalArgumentException {

    public LottoNumberRangeException() {
        super(String.format(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage(), LottoRule.START_NUMBER, LottoRule.END_NUMBER));
    }
}
