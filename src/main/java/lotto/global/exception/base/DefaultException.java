package lotto.global.exception.base;

public class DefaultException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    public DefaultException(ErrorBase error) {
        super(ERROR_MESSAGE_HEADER + error.getErrorMessage());
    }

}
