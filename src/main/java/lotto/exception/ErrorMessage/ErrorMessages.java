package lotto.exception.ErrorMessage;

public enum ErrorMessages {
    ERROR_MESSAGES("[ERROR] "),
    EMPTY_INPUT_EXCEPTION_MESSAGE("아무 값도 입력하지 않았습니다."),
    NOT_NUMBER_EXCEPTION_MESSAGE("숫자를 입력해야 합니다."),
    NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE("구입 금액은 1000원으로 나누어 떨어져야 합니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
