package lotto.exception;

public enum CommonExceptionMessage {
    PREFIX_EXCEPTION("[ERROR]");

    private final String message;

    CommonExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
