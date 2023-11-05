package lotto.util.exception.operation;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.MathOperationException;

public class AmountParseException extends MathOperationException {
    public AmountParseException() {
        super(ErrorMessage.AMOUNT_CANNOT_PARSE);
    }
}
