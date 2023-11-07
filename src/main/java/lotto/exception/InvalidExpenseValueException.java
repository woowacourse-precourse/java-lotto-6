package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_EXPENSE_VALUE_ERROR;
import static lotto.service.OutputService.printError;

public class InvalidExpenseValueException extends IllegalArgumentException {
    public InvalidExpenseValueException() {
        printError(LOTTO_EXPENSE_VALUE_ERROR);
    }
}
