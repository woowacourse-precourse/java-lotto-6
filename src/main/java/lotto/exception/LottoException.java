package lotto.exception;

public abstract class LottoException extends IllegalArgumentException {
    public LottoException(String message) {
        super("[ERROR] " + message);
    }
}
