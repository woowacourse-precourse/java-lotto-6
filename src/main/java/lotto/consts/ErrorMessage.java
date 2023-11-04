package lotto.consts;

public enum ErrorMessage {
    ERROR_MESSAGE_INPUT_MUST_BE_NUMBER("숫자로 입력해주세요."),
    ERROR_MESSAGE_AMOUNT_UNIT("로또 1장의 가격은 1,000원 입니다.");
    private final String message;
    private final String defaultMessage = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return defaultMessage + message;
    }
}
