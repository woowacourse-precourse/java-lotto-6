package lotto.util.exception.operation;

import static lotto.util.Constants.ERROR;

import lotto.util.enums.ErrorMessage;

public class AmountParseException extends NumberFormatException {
    private final String message;

    public AmountParseException() {
        this.message = ERROR + ErrorMessage.AMOUNT_CANNOT_PARSE.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
