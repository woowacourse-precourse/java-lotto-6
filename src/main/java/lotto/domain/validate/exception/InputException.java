package lotto.domain.validate.exception;

public enum InputException {
    NOT_IN_RANGE_MONEY("1000이상 50000이하의 값을 입력하십시오."),
    NOT_DIVIDED_BY_1000("1000으로 나눠 떨어지는 값을 입력하십시오."),
    NO_NUMBER("숫자 값을 입력하십시오."),
    NOT_DISTINCTNESS("6개의 중복되지 않은 숫자 값을 입력하십시오."),
    NOT_IN_RANGE_LOTTO_NUMBER("입력된 로또 숫자 값을 1-45 사이로 입력하십시오."),
    NOT_DISTINCT_BONUS_NUMBER("당첨 번호와 보너스 번호가 중복되지 않게 입력하십시오.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
