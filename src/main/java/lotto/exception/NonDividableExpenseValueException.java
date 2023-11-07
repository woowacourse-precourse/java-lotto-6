package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_EXPENSE_NONDIVIDABLE_ERROR;
import static lotto.service.OutputService.printError;

public class NonDividableExpenseValueException extends IllegalArgumentException {
    public NonDividableExpenseValueException() {
        printError(LOTTO_EXPENSE_NONDIVIDABLE_ERROR);
    }
}
