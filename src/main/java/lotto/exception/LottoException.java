package lotto.exception;

public class LottoException extends RuntimeException {
    private static final String ERROR = "[ERROR] ";

    public LottoException(String message) {
        super(ERROR + message);
    }
}
