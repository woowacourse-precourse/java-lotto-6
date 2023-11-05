package lotto.util;

public enum ErrorMessage {
    NOT_NUMBER_INPUTTED("구입할 금액은 숫자로 입력해야합니다."),
    TOO_LARGE_NUMBER("입력한 숫자가 너무 큽니다."),
    MINUS_MONEY("금액은 양수여야합니다."),
    NOT_DIVIDED_BY_LOTTO_PRICE("1,000원으로 나누어떨어지는 금액만 입력 가능합니다.");

    private static final String ERROR_CODE = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_CODE + message;
    }
}
