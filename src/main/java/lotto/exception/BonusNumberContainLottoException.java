package lotto.exception;

import lotto.constants.message.ErrorMessage;

public class BonusNumberContainLottoException extends IllegalArgumentException {
    public BonusNumberContainLottoException() {
        super(ErrorMessage.BONUS_NUMBER_CONTAIN_LOTTO_ERROR.getMessage());
    }
}
