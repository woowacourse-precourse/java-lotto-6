package lotto.domain.exception;

import lotto.common.LottoException;

public class DuplicatedLottoNumberException extends LottoException {
    private static final String MESSAGE = "중복된 로또 번호가 존재합니다.";

    public DuplicatedLottoNumberException() {
        super(MESSAGE);
    }
}
