package lotto;

public enum ErrorMessage {

    INVALID_INTEGER_INPUT("정수만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
