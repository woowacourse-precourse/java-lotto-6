package lotto.exception;

public enum ErrorMessage {
    /**
     * Client issue
     */
    PAYMENT_NOT_INTEGER("구입 비용(Payment)은 정수가 입력되어야 합니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1에서 45사이의 숫자여야 합니다."),
    PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE("구입 비용(Payment)은 1,000원 단위로 입력되어야 합니다."),


    /**
     * System Issue
     */
    NUMBER_COUNT_INVALID("뽑은 로또의 갯수가 시스템 설정과 다릅니다."),
    NUMBER_DUPLICATED("뽑은 로또 중 중복된 숫자가 있습니다.");


    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
