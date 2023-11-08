package lotto.exception.lottoseller;

import lotto.exception.common.CustomArgumentException;

public class InsufficientMoneyException extends CustomArgumentException {
    private static final String MESSAGE = "구입 금액이 로또 가격보다 작습니다.";

    public InsufficientMoneyException() {
        super(MESSAGE);
    }
}
