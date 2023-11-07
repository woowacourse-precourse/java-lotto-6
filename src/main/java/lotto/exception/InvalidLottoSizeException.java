package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_SIZE_ERROR;
import static lotto.service.OutputService.printError;

public class InvalidLottoSizeException extends IllegalArgumentException {
    public InvalidLottoSizeException() {
        printError(LOTTO_SIZE_ERROR);
    }
}
