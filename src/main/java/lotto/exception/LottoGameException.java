package lotto.exception;

public class LottoGameException extends IllegalArgumentException {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public LottoGameException(String s) {
        super(ERROR_PREFIX + s);
    }
}
