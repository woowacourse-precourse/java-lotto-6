package lotto.exception.input;

import lotto.exception.common.CustomArgumentException;

public class NotIntegerException extends CustomArgumentException {
    public static final String MESSAGE = "숫자만 입력 가능합니다.";

    public NotIntegerException() {
        super(MESSAGE);
    }
}
