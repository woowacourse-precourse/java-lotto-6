package lotto.exception;

import lotto.constants.lotto.LottoRule;
import lotto.constants.message.ErrorMessage;

public class LottoNumbersSizeException extends IllegalArgumentException {

    public LottoNumbersSizeException() {
        super(String.format(ErrorMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage(), LottoRule.NUMBER_MAX_SIZE));
    }
}
