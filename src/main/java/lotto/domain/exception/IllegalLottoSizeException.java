package lotto.domain.exception;

import lotto.common.LottoException;

public class IllegalLottoSizeException extends LottoException {
    private static final String MESSAGE = "로또 번호의 개수는 6개여야 합니다.";

    public IllegalLottoSizeException() {
        super(MESSAGE);
    }
}
