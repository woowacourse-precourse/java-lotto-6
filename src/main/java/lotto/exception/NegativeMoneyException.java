package lotto.exception;

public class NegativeMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "로또 구입 금액은 0 이상이여야 합니다.";

    public NegativeMoneyException() {
        super(ERROR_MESSAGE);
    }
}
