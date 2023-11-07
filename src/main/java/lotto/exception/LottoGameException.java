package lotto.exception;

public class LottoGameException extends IllegalArgumentException {
    private static final String MESSAGE_PREFIX = "[ERROR] ";

    public LottoGameException(ErrorCode errorCode) {
        super(MESSAGE_PREFIX + errorCode.getMessage());
    }
}
