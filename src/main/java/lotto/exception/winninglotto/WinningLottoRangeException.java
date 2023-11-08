package lotto.exception.winninglotto;

import lotto.exception.common.CustomArgumentException;

public class WinningLottoRangeException extends CustomArgumentException {
    private static final String MESSAGE = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public WinningLottoRangeException() {
        super(MESSAGE);
    }
}
