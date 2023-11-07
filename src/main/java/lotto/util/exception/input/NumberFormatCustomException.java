package lotto.util.exception.input;

import static lotto.util.Constants.ERROR;
import static lotto.util.enums.ErrorMessage.NUMBER_CANNOT_PARSE;

public class NumberFormatCustomException extends NumberFormatException{
    public NumberFormatCustomException() {
        super(ERROR + NUMBER_CANNOT_PARSE.getMessage());
    }
}
