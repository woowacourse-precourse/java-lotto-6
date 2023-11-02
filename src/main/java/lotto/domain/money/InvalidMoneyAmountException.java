package lotto.domain.money;

public final class InvalidMoneyAmountException extends IllegalArgumentException {
    public static final String INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE = "잔액은 음수가 될 수 없습니다";

    public InvalidMoneyAmountException() {
        super(INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE);
    }
}
