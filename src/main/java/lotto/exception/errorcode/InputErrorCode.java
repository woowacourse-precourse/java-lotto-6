package lotto.exception.errorcode;

import static lotto.exception.errorcode.ErrorCodeConstants.ERROR_MESSAGE_PREFIX;

public enum InputErrorCode {

    INVALID_LOTTO_NUMBER_RANGE(ERROR_MESSAGE_PREFIX + "로또 번호의 범위는 1 ~ 45 사이여야 합니다."),
    INVALID_LOTTO_NUMBERS_SIZE(ERROR_MESSAGE_PREFIX + "로또 번호는 총 6개여야 합니다.");

    private final String message;

    InputErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
