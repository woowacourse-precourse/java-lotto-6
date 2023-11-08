package lotto.exception;

public class InvalidLottoNumberException extends IllegalArgumentException {
    public InvalidLottoNumberException(String s) {
        super(s);
    }

    public InvalidLottoNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLottoNumberException(Throwable cause) {
        super(cause);
    }
}
