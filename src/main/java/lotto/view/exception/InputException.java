package lotto.view.exception;

public enum InputException {

    NUMBER_FORMAT_EXCEPTION("숫자여야 합니다.");

    private static final String DEFAULT_MESSAGE = "[ERROR] ";
    
    private final String message;

    InputException(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return DEFAULT_MESSAGE + message;
    }
}
