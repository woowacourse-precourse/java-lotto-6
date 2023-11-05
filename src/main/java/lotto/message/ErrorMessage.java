package lotto.message;

public enum ErrorMessage implements MessageProvider{
    INVALID_COUNT_FORMAT("[ERROR] 숫자 형식으로 입력해주세요.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
