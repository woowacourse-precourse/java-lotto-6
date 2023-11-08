package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_EXPENSE_NONDIVIDABLE_ERROR;

public class NonDividableExpenseValueException extends IllegalArgumentException {
    public NonDividableExpenseValueException() {
        super(LOTTO_EXPENSE_NONDIVIDABLE_ERROR);
    }
}
