package util;

public enum ErrorMessage {

    LOTTO_COUNT_LIMIT("로또 번호의 개수는 6개여야 합니다."),
    ERROR("[ERROR] ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR.message + message;
    }
}