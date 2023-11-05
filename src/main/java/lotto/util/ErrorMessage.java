package lotto.util;

public enum ErrorMessage {
    ILLEGAL_ARGUMENTS_MONEY("금액은 1,000으로 나누어 떨어지는 정수여야 합니다.");


    private final String message;
    private static final String prefix = "[ERROR] ";
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
