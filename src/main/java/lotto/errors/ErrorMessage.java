package lotto.errors;

public enum ErrorMessage implements MainErrorMessage {

    WRONG_NUMBER_FORMAT("정수인 숫자를 입력해야 합니다."),
    NOT_ZERO("0은 입력할 수 없습니다."),
    WRONG_COST("1000의 배수를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = START_ERROR_MESSAGE + message + END_ERROR_MESSAGE;
    }

    public String getMessage() {
        return message;
    }
}
