package lotto.enums;

public enum ErrorMessage {
    NUMERIC_ERROR("[ERROR] 숫자가 아닌 입력값입니다."),
    LESS_AMOUNT_ERROR("[ERROR] 1000원 이상을 입력해야합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
