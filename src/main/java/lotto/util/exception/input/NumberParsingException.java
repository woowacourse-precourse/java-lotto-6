package lotto.util.exception.input;


import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InvalidNumberFormatException;

public class NumberParsingException extends InvalidNumberFormatException {
    public NumberParsingException() {
        super(ErrorMessage.NUMBER_CANNOT_PARSE);
    }
}
