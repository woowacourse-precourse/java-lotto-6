package lotto.exception.lotto;

import lotto.exception.common.CustomArgumentException;

public class LottoLengthException extends CustomArgumentException {

    public static final String MESSAGE = "로또 번호는 6개여야 합니다.";

    public LottoLengthException() {
        super(MESSAGE);
    }
}
