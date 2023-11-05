package lotto.validator.ErrorMessage;

public enum ErrorMessages {
    ERROR_MESSAGES("[ERROR] "),
    EMPTY_INPUT_EXCEPTION_MESSAGE("아무 값도 입력하지 않았습니다."),
    NOT_NUMBER_EXCEPTION_MESSAGE("숫자를 입력해야 합니다."),
    NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE("구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    NOT_IN_RIGHT_RANGE_EXCEPTION_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_RIGHT_AMOUNT_OF_WINNING_NUMBER_EXCEPTION_MESSAGE("6개의 숫자를 입력해야 합니다."),
    DUPLICATED_NUMBER_EXCEPTION_MESSAGE("중복되지 않은 숫자를 입력해야 합니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
