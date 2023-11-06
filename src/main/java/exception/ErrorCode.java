package exception;

public enum ErrorCode {
    MoneyInputError("[ERROR]1,000원으로 나누어 떨어지는 수를 입력해야 합니다.\n");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
