package lotto.constants;

public enum ErrorMessage {
    ERROR_TAG("[ERROR] "),
    NOT_NUMERIC_ERROR("숫자를 입력해 주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG.message + message;
    }

    @Override
    public String toString() {
        return message;
    }
}
