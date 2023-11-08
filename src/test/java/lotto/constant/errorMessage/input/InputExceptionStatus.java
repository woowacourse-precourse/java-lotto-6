package lotto.constant.errorMessage.input;

import lotto.constant.errorMessage.ExceptionStatus;

public enum InputExceptionStatus implements ExceptionStatus {

    READ_IS_NOT_NUMERIC("숫자만 입력할 수 있습니다."),
    READ_IS_NULL("NULL 은 입력할 수 없습니다."),
    AMOUNT_IS_NOT_POSITIVE("구입 금액은 양의 정수만 입력할 수 있습니다."),
    AMOUNT_IS_NOT_ABOVE("구입 금액은 1000 보다 큰 숫자만 입력할 수 있습니다."),
    AMOUNT_IS_NOT_DIVISIBLE("구입 금액은 1000 단위로 나누어 떨어지는 숫자만 입력할 수 있습니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    private final String message;

    InputExceptionStatus(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
