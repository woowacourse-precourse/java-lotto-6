package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_IN_RANGE_ERROR;
import static lotto.service.OutputService.printError;

public class LottoNumOutOfRangeException extends IllegalArgumentException {
    public LottoNumOutOfRangeException() {
        printError(LOTTO_IN_RANGE_ERROR);
    }
}
