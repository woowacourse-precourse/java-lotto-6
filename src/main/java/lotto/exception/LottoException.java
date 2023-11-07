package lotto.exception;

import lotto.constant.Error;

public class LottoException {

    private static LottoException lottoException = new LottoException();

    private LottoException() {
    }

    public static LottoException getLottoException() {
        return lottoException;
    }

    public void invalidCount() {
        throw new IllegalArgumentException(Error.INVALID_NUMBER_COUNT.getMessage());
    }

    public void duplicateNumber() {
        throw new IllegalArgumentException(Error.DUPLICATED_NUMBER.getMessage());
    }
}
