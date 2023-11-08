package lotto.common.exception;

public class LottoGameException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public LottoGameException(ErrorType errorType) {
        super(ERROR_MESSAGE_PREFIX + errorType.getMessage());
    }

    public static LottoGameException withType(ErrorType errorType) {
        return new LottoGameException(errorType);
    }
}
