package lotto.util.exception.operation;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.MathOperationException;

public class AmountCannotParseException extends MathOperationException {
    public AmountCannotParseException() {
        super(ErrorMessage.AMOUNT_CANNOT_PARSE);
    }
}
