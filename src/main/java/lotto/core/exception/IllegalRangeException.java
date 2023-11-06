package lotto.core.exception;

import static lotto.core.enums.LottoNumberEnum.END_VALUE;
import static lotto.core.enums.LottoNumberEnum.START_VALUE;

import lotto.core.enums.LottoNumberEnum;

public class IllegalRangeException extends LottoApplicationException {

    private static final String DEFAULT_MESSAGE =
            "범위를 벗어났습니다. 다시 입력해 주세요.";

    public IllegalRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
