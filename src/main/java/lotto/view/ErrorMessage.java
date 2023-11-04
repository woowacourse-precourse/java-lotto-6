package lotto.view;

public enum ErrorMessage {

    ERROR_MESSAGE_PREFIX("[ERROR] "),
    DUPLICATED_LOTTO("로또 번호에 중복이 있습니다"),
    INVALID_LOTTO_LENGTH("로또 번호의 개수가 맞지 않습니다"),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호의 범위가 맞지 않습니다");

    private final String message;

    public String getErrorMessage() {
        return ERROR_MESSAGE_PREFIX.message + message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
