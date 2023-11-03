package lotto.constants;

public enum ErrorMessage {
    ERROR_TAG("[ERROR] "),
    NOT_NUMERIC_ERROR("숫자를 입력해 주세요"),
    NOT_THOUSAND_UNIT_ERROR("1000단위로 입력을 해주세요");

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
