package lotto.exception;

public class ZeroMoneyException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "구입 금액은 0이면 안 됩니다.";

    public ZeroMoneyException() {
        super(ERROR_MESSAGE);
    }
}
