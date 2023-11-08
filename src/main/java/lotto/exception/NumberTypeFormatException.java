package lotto.exception;

public class NumberTypeFormatException extends NumberFormatException {

    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "숫자 이외에 다른 형식이 있습니다.";

    public NumberTypeFormatException() {
        super(ERROR_MESSAGE);
    }
}
