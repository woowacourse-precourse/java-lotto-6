package lotto.util.exception.operation;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.MathOperationException;

public class AmountCannotDivisionException extends MathOperationException {
    public AmountCannotDivisionException() {
        super(ErrorMessage.AMOUNT_CANNOT_DIVISION);
    }
}
