package lotto.constant;

public enum ErrorMessage {
    NON_INTEGER("올바른 숫자를 입력해 주세요.");

    public static final String ERROR = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(ERROR, message);
    }

    public String getMessage() {
        return message;
    }
}
