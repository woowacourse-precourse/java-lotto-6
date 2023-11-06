package lotto.exception;

public class LottoGameException extends IllegalArgumentException {
    public LottoGameException(String message) {
        super("[ERROR] " + message);
    }
}
