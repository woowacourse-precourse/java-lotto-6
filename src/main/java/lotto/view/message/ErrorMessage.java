package lotto.view.message;

public enum ErrorMessage {
    DEFAULT_ERROR_MESSAGE("[ERROR] "),
    NOT_DEFAULT_LOTTO_SIZE("숫자의 개수가 6개가 아닙니다."),
    DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE("1 ~ 45 사이가 아닌 숫자가 있습니다."),
    EMPTY_INPUT("빈 입력입니다."),
    NOT_NUMBER("숫자가 아닌 문자가 포함되었습니다."),
    NOT_PRICE_UNITS("구입 금액이 1,000원 단위가 아닙니다."),
    DUPLICATED_NUMBER_IN_WINNING_LOTTO("입력한 당첨 번호에 중복된 숫자가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    private String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return DEFAULT_ERROR_MESSAGE.getMessage() + message;
    }
}
