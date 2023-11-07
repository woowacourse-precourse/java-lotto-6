package lotto.enums;

public enum ErrorMessage {
    NUMERIC_ERROR("[ERROR] 숫자가 아닌 입력값입니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
