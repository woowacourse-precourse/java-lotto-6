package lotto.exception;

public class LottoIllegalArgumentException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[Error] ";

    public LottoIllegalArgumentException(String message) {
        super(ERROR_PREFIX + message);
    }
}
