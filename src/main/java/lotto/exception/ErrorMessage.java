package lotto.exception;

public enum ErrorMessage {
    NOT_POSITIVE_INTEGER("양의 정수만 입력가능합니다.");

    private final String message;
    public static final String header = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return header + message;
    }


}
