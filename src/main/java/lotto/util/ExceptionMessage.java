package lotto.util;

public enum ExceptionMessage {
    NOT_NUMERIC("입력값을 다시 확인해주세요.");

    private static final String ERROR = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String errorMessage) {
        this.message = String.format(ERROR, errorMessage);
    }

    public String getMessage() {
        return message;
    }
}
