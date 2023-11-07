package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_EXPENSE_VALUE_ERROR;

public class InvalidExpenseValueException extends IllegalArgumentException {
    public InvalidExpenseValueException() { super(LOTTO_EXPENSE_VALUE_ERROR); }
}
