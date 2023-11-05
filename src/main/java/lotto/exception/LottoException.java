package lotto.exception;

public class LottoException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public LottoException(LottoExceptionMessage errorMessage) {
        super(ERROR_MESSAGE_PREFIX + errorMessage.getMessage());
    }

}

