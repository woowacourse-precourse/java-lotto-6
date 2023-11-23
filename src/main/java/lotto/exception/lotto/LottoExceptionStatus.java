package lotto.exception.lotto;

import lotto.exception.ExceptionStatus;

public enum LottoExceptionStatus implements ExceptionStatus {

    LOTTO_IS_DUPLICATED("중복될 수 없습니다."),
    LOTTO_IS_OUT_OF_SIZE("여섯 개 만 입력 가능합니다."),
    LOTTO_IS_OUT_OF_RANGE("1부터 45 사이의 숫자여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MESSAGE_PREFIX = "로또 볼 넘버는 ";
    private static final String MESSAGE_SUFFIX = "다시 입력해 주세요.";

    private final String message;

    LottoExceptionStatus(final String message) {
        this.message = ERROR_PREFIX + MESSAGE_PREFIX + message + MESSAGE_SUFFIX;
    }

    public String getMessage() {
        return this.message;
    }
}
