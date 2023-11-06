package lotto.constant;

public enum ErrorMessageConstant {
    ERROR("[ERROR]"),
    DUPLICATE_NUMBER_ERROR_MESSAGE("중복된 숫자를 입력하셨습니다.");

    private final String message;

    ErrorMessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return ERROR.getMessage() + " " + message;
    }
}
