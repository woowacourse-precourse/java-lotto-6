package lotto.view.exception;

import lotto.view.message.LottoInputExceptionMessage;

public class LottoInputException extends IllegalArgumentException {
    private LottoInputException(final LottoInputExceptionMessage lottoInputExceptionMessage) {
        super(lottoInputExceptionMessage.getMessage());
    }

    public static LottoInputException of(final LottoInputExceptionMessage lottoInputExceptionMessage) {
        return new LottoInputException(lottoInputExceptionMessage);
    }
}