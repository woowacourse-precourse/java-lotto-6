package lotto.errorMessage;

public enum ErrorMessage {
    CHECK_BLANK("[ERROR] 입력값이 공백입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
