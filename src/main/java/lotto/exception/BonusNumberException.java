package lotto.exception;

public class BonusNumberException extends IllegalArgumentException {

    public BonusNumberException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}