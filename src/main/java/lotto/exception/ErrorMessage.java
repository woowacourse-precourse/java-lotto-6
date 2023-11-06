package lotto.exception;

public enum ErrorMessage {
    INPUT_IS_NULL("null 값이 입력 되었습니다."),
    INPUT_IS_EMPTY("빈 값이 입력 되었습니다.");

    private static final String ERROR_HEAD = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_HEAD + errorMessage;
    }
}