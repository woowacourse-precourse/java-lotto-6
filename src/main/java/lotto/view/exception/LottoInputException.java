package lotto.view.exception;

import lotto.view.message.LottoInputExceptionMessage;

public class LottoInputException extends IllegalArgumentException {
    private LottoInputException(LottoInputExceptionMessage lottoInputExceptionMessage) {
        super(lottoInputExceptionMessage.getMessage());
    }

    public static LottoInputException of(LottoInputExceptionMessage lottoInputExceptionMessage) {
        return new LottoInputException(lottoInputExceptionMessage);
    }
}