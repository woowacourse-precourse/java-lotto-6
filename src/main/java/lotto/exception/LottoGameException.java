package lotto.exception;

import lotto.enums.ErrorMessage;

public class LottoGameException extends Exception {
    public LottoGameException(ErrorMessage message) {
        super(message.getMessage());
    }
}
