package lotto.constant.message;

public enum ErrorMessage {
    NON_INTEGER_MONEY("올바른 숫자의 금액을 입력해 주세요.");

    public static final String ERROR = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(ERROR, message);
    }

    public String getMessage() {
        return message;
    }
}
