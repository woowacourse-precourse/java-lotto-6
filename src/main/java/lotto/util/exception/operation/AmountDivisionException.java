package lotto.util.exception.operation;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.MathOperationException;

public class AmountDivisionException extends MathOperationException {
    public AmountDivisionException() {
        super(ErrorMessage.AMOUNT_CANNOT_DIVISION);
    }
}
