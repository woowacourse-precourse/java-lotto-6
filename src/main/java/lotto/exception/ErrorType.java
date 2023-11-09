package lotto.exception;

public enum ErrorType {

    INVALID_TICKET_SIZE("로또 번호의 개수는 6개여야 합니다."),
    NUMBERS_DUPLICATED("로또 번호는 중복될 수 없습니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    MONEY_LESS_THAN_PRIZE("금액은 1,000원 이상이어야 합니다."),
    MONEY_CANT_DIVIDED_BY_PRIZE("금액은 1,000원으로 나누어 떨어지는 수어야 합니다."),
    BONUS_DUPLICATED("보너스 번호는 로또 번호에 포함되지 않는 숫자여야 합니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
