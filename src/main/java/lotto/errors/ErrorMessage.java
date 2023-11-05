package lotto.errors;

public enum ErrorMessage implements MainErrorMessage {

    WRONG_NUMBER_FORMAT("정수인 숫자를 입력해 주세요."),
    WRONG_COST("1000의 배수로 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = MAIN_ERROR_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
