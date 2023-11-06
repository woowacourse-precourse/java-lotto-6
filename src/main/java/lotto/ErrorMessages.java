package lotto;

public enum ErrorMessages {
    INVALID_LONG("[ERROR] 정수값을 입력해주세요."),
    INVALID_DIVIDE_NUMBER("[ERROR] 1,000으로 나누어 떨어지는 값을 입력해주세요.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
