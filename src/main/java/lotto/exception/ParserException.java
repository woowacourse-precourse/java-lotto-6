package lotto.exception;

public class ParserException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public ParserException(ParserExceptionMessage errorMessage) {
        super(ERROR_MESSAGE_PREFIX + errorMessage.getMessage());
    }

}

