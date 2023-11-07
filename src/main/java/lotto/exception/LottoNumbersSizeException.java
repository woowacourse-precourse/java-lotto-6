package lotto.exception;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

public class LottoNumbersSizeException extends IllegalArgumentException {

    public LottoNumbersSizeException() {
        super(String.format(ErrorMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage(), LottoRule.NUMBER_MAX_SIZE));
    }
}
