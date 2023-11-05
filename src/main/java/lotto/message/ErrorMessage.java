package lotto.message;

public enum ErrorMessage implements Message {
    ERROR_PREFIX("[ERROR] %s"),
    NOT_BLANK("공백과 빈 문자열을 허용하지 않습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
