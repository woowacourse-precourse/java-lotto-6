package lotto.exception;

public enum ExceptionMessage {
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복이 있을수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format(final Object... args) {
        return String.format(message, args);
    }
}
