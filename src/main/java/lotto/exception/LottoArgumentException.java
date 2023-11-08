package lotto.exception;

public class LottoArgumentException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_PREFIX ="[ERROR] ";

    public LottoArgumentException(ErrorStatus errorStatus) {
        super(ERROR_MESSAGE_PREFIX.concat(errorStatus.getMessage()));
    }
}
