package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_NUM_TYPE_ERROR;
import static lotto.service.OutputService.printError;

public class InvalidNumberTypeException extends IllegalArgumentException {
    public InvalidNumberTypeException() {
        printError(LOTTO_NUM_TYPE_ERROR);
    }
}
