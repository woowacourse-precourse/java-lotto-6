package lotto.exception;

import java.util.function.Consumer;

public enum ErrorMessage {
    PAYMENT_NOT_INTEGER("지불 비용은 정수가 입력되어야 합니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1에서 45사이의 숫자여야 합니다."),
    PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE("지불 비용은 1,000원 단위여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

    public void invoke(Consumer<String> consumer) {
        consumer.accept(ERROR_PREFIX + message);
    }
}
