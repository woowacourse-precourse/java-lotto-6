package lotto.constants;

public enum ErrorMessage {
    NUMBER_FORMAT("숫자를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
