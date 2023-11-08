package lotto.view;

public enum ErrorMessage {
    INVALID_VALUE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OVER_SIZE("로또 번호의 개수는 6개여야 합니다."),
    DUPLICATE_NUM("로또 번호는 중복되면 안됩니다."),
    NOT_NUMBER("숫자만 입력해야 합니다.")
    ;


    private final String message;

    private final String ERROR = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
