package lotto.util;

public enum ErrorMessage {
    INVALID_NUMERIC("숫자만 입력 가능합니다."),
    INVALID_MINIMUM_AMOUNT("최소 구매 금액은 1,000원 입니다."),
    INVALID_AMOUNT_UNIT("1,000원 단위로 입력해 주세요."),
    INVALID_AMOUNT_LENGTH("1,000,000,000원 보다 적은 금액을 입력해주세요."),
    INVALID_OUT_OF_RANGE("로또는 1부터 45까지의 숫자만 사용됩니다."),
    INVALID_LOTTO_SIZE("6개의 숫자를 입력해 주세요."),
    DUPLICATE_NUMBER("중복된 번호가 존재합니다. 다른 번호를 입력해주세요.");

    private static final String ERROR_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(ERROR_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
