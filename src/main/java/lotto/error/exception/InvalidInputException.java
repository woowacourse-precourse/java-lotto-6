package lotto.error.exception;

public class InvalidInputException extends IllegalArgumentException {
    private final String messageKey;
    private final Object[] params;

    public InvalidInputException(String messageKey, Object... params) {
        this.messageKey = messageKey;
        this.params = params;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public Object[] getParams() {
        return params;
    }
}
