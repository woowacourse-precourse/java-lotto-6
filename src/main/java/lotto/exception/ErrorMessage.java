package lotto.exception;

public enum ErrorMessage {
    EMPTY("[ERROR] 아무 것도 입력되지 않았습니다."),
    INCORRECT_NUMBER_FORMAT("[ERROR] 숫자 형식이 아닙니다."),
    INCORRECT_WIN_NUMBER_FORMAT("[ERROR] 올바르지 않은 형식입니다."),
    START_LETTER_ZERO("[ERROR] 올바르지 않은 숫자입니다."),
    INCORRECT_THOUSAND_UNIT("[ERROR] 1,000원 단위로 입력해주세요."),
    NOT_SIX_NUMBER("[ERROR] 6개의 숫자를 입력해주세요."),
    NOT_IN_INPUT_RANGE("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요."),
    DUPLICATE_NUMBER("[ERROR] 당첨 번호와 다른 번호를 입력해주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
