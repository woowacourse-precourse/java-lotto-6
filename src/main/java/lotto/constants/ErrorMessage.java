package lotto.constants;

public enum ErrorMessage {
    ERROR_IS_NOT_NUMBER("올바른 입력을 하지 않았습니다."),
    ERROR_CANT_DIVIDED_BY_LOTTO_PRICE("올바른 금액을 입력하지 않았습니다."),
    ERROR_IS_NOT_A_VALID_FORMAT("올바른 형식에 맞춰 입력하지 않았습니다."),
    ERROR_IS_NOT_INTERVAL_VALUE("숫자 범위를 벗어난 입력을 하였습니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
