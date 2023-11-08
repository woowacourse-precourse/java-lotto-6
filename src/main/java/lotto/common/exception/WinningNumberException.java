package lotto.common.exception;

public class WinningNumberException extends IllegalArgumentException {
    public WinningNumberException(WinningNumberErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}
