package lotto.exception.winninglotto;

import lotto.exception.common.CustomArgumentException;

public class WinningLottoDistinctException extends CustomArgumentException {
    private static final String MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public WinningLottoDistinctException() {
        super(MESSAGE);
    }
}
