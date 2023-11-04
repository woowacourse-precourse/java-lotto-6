package lotto.constant;

public enum ErrorMessage {
    ERROR("[ERROR]"),
    NOT_NUMERIC("수를 입력해주세요."),
    NOT_DIVISIBLE("%d 단위로 떨어지는 구매 금액을 입력해주세요."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message + message;
    }
}
