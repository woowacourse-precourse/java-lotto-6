package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_DUPLICATE_ERROR;
import static lotto.service.OutputService.printError;

public class DuplicateLottoException extends IllegalArgumentException {
    public DuplicateLottoException() {
        printError(LOTTO_DUPLICATE_ERROR);
    }
}
