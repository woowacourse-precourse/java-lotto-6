package lotto.exception.lotto;

import lotto.exception.common.CustomArgumentException;

public class LottoDistinctException extends CustomArgumentException {

    public static final String MESSAGE = "로또 번호는 중복된 숫자가 없어야 합니다.";

    public LottoDistinctException() {
        super(MESSAGE);
    }
}
