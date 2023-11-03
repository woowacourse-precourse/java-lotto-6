package lotto;

public enum ErrorMessages {
    ERROR_NOT_NUMBER("[ERROR] 숫자만 입력해 주세요");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
