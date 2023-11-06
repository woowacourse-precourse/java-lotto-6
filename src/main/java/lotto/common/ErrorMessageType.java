package lotto.common;

/**
 * @Enum : 에러 메시지 타입 열거형
 */
public enum ErrorMessageType {
    ERROR_NON_NUMERIC_INPUT("옳바른 숫자여야 합니다."),
    ERROR_MIN_LOTTO_AMOUNT_UNIT("구입 금액은 1,000 단위의 숫자여야 합니다."),
    ERROR_DUPLICATE_NUMBER("숫자는 중복될 수 없습니다."),
    ERROR_INVALID_LOTTO_SIZE("로또 번호는 6개의 숫자여야 합니다."),
    ERROR_INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_DUPLICATE_BOUNUS_NUMBER("보너스 번호는 로또 번호와 중복되지 않는 수자여야 합니다."),
    ;

    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getLottoMessage() {
        return "[ERROR] " + message;
    }
}
