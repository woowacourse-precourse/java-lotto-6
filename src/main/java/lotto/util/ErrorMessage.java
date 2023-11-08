package lotto.util;

public enum ErrorMessage {
    IS_EMPTY("값을 입력해 주세요."),
    IS_NOT_NUMBER("숫자를 입력해 주세요."),
    IS_NOT_DIVIDED_BY_PRICE("로또 금액 단위로 금액을 투입해 주세요."),
    IS_NOT_POSITIVE_NUMBER("투입 금액은 음수가 될 수 없습니다."),
    IS_NOT_OVER_MIN_PRICE("로또를 구매할 돈이 부족합니다."),
    IS_NOT_LAST_INDEX("입력 형태를 확인해 주세요 [입력 예시 : 1,2,3,4,5,6]"),
    IS_NOT_LOTTO_SIZE("로또는 6개의 숫자가 필요합니다."),
    IS_NOT_LOTTO_NUMBER_RANGE("로또 번호는 1 ~ 45 사이의 숫자 이어야 합니다."),
    IS_NOT_UNIQUE_LOTTO_NUMBER("로또 번호는 서로 중복될 수 없습니다."),
    IS_NOT_VALID("는 유효하지 않은 값입니다.");

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}