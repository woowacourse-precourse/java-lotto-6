package lotto.util;

public enum ExceptionMessage {
    INVALID_INPUT_FORMAT("값은 정수로만 입력할 수 있습니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_PURCHASE_UNIT("구매 금액은 1000 단위로 입력해주세요."),
    INVALID_LOTTO_PURCHASE_MIN_RANGE("구매 금액은 1000 이상의 자연수로 입력해주세요."),
    INVALID_LOTTO_PURCHASE_MAX_RANGE("구매 금액은 2147483000 이하의 자연수로 입력해주세요.");

    public static final String BASE_MESSAGE = "[ERROR] %s";

    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
