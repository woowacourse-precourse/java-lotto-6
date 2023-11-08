package lotto.domain.exception;

import lotto.domain.message.LottoInputExceptionMessage;

public class LottoInputException extends IllegalArgumentException {
    private LottoInputException(final LottoInputExceptionMessage lottoInputExceptionMessage) {
        super(lottoInputExceptionMessage.getMessage());
    }

    public static LottoInputException of(final LottoInputExceptionMessage lottoInputExceptionMessage) {
        return new LottoInputException(lottoInputExceptionMessage);
    }
}