package lotto.exception;

public class RangeMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "로또 구입 금액은 0 이상이여야 합니다.";

    public RangeMoneyException() {
        super(ERROR_MESSAGE);
    }
}
