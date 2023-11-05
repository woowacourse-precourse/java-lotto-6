package lotto.model;

public enum ErrorType {

    MONEY_LESS_THEN_PRIZE("금액은 1,000원 이상이어야 합니다."),
    MONEY_CANT_DIVIDED_BY_PRIZE("금액은 1,000원으로 나누어 떨어지는 수어야 합니다.");

    private static final String PREFIX = "[ERROR]";

    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + " " + message;
    }
}
