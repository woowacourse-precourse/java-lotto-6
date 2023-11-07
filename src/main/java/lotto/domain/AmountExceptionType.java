package lotto.domain;

public enum AmountExceptionType {
    NOT_INTEGER("구입금액은 정수여야 합니다."),
    NOT_POSITIVE("구입금액은 0보다 큰 정수여야 합니다."),
    NOT_DIVIDED_BY_PRICE("구입금액은 1000원 단위로 나누어떨어져야 합니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    private final String message;

    private AmountExceptionType(String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
