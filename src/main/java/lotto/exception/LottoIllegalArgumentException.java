package lotto.exception;

public class LottoIllegalArgumentException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public LottoIllegalArgumentException(String message) {
        super(ERROR_PREFIX + message);
    }
}
