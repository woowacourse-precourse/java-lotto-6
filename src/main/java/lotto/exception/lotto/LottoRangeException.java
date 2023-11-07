package lotto.exception.lotto;

import lotto.exception.common.CustomArgumentException;

public class LottoRangeException extends CustomArgumentException {
    public static final String MESSAGE = "로또 번호는 1부터 45사이의 숫자여야 합니다.";

    public LottoRangeException() {
        super(MESSAGE);
    }
}
