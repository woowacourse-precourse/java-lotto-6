package lotto.constant;

public enum ErrorMessage {
    ERROR("[ERROR]"),
    NOT_NUMERIC("수를 입력해주세요."),
    NOT_DIVISIBLE("%d 단위로 떨어지는 구매 금액을 입력해주세요."),
    NOT_UNIQUE("중복되지 않도록 수를 입력해주세요."),
    NOT_LENGTH("쉼표로 구분하여 6개의 수를 입력해주세요.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message + message;
    }
}
