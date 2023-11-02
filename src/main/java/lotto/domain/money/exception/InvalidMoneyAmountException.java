package lotto.domain.money.exception;

/**
 * Money의 잔액이 음수일 경우 발생하는 예외입니다.
 */
public final class InvalidMoneyAmountException extends IllegalArgumentException {
    public static final String INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE = "잔액은 음수가 될 수 없습니다";

    public InvalidMoneyAmountException() {
        super(INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE);
    }
}
