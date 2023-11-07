package lotto.view.message;

public enum ErrorMessage {
    DEFAULT_ERROR_MESSAGE("[ERROR] "),
    NOT_DEFAULT_LOTTO_SIZE("로또 번호의 개수가 6개가 아닙니다."),
    DUPLICATED_NUMBER("로또 번호에 중복된 숫자가 있습니다.");

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
