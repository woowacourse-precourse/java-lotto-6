package lotto.exception;

import lotto.constants.lotto.LottoRule;
import lotto.constants.message.ErrorMessage;

public class LottoNumberRangeException extends IllegalArgumentException {

    public LottoNumberRangeException() {
        super(String.format(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage(), LottoRule.START_NUMBER, LottoRule.END_NUMBER));
    }
}
