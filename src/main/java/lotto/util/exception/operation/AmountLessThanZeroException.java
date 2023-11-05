package lotto.util.exception.operation;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.MathOperationException;

public class AmountLessThanZeroException extends MathOperationException {
    public AmountLessThanZeroException() {
        super(ErrorMessage.AMOUNT_CANNOT_BE_LESS_THAN_ZERO);
    }
}
