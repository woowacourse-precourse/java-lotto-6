package lotto.exception.lottoseller;

import lotto.exception.common.CustomArgumentException;

public class NonMultipleMoneyException extends CustomArgumentException {
    private static final String MESSAGE = "로또 가격의 배수가 아닙니다.";

    public NonMultipleMoneyException() {
        super(MESSAGE);
    }
}
