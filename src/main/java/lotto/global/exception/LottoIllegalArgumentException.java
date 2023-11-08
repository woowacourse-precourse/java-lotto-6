package lotto.global.exception;

import lotto.global.constant.message.ErrorMessage;

public class LottoIllegalArgumentException extends IllegalArgumentException {
    public LottoIllegalArgumentException(ErrorMessage message) {
        super(message.getText());
    }
}
