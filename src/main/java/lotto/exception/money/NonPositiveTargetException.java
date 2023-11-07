package lotto.exception.money;

import lotto.exception.common.CustomArgumentException;

public class NonPositiveTargetException extends CustomArgumentException {
    private static final String MESSAGE = "연산 대상 값은 양수이어야 합니다.";

    public NonPositiveTargetException() {
        super(MESSAGE);
    }
}
