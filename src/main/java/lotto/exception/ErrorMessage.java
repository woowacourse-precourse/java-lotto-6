package lotto.exception;

public enum ErrorMessage {
    VALIDATE_INPUT_EMPTY("입력값은 비어있으면 안됩니다."),
    VALIDATE_INPUT_NUMBER("입력값은 숫자만 가능합니다."),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
