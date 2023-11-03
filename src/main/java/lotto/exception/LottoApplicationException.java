package lotto.exception;

public class LottoApplicationException extends IllegalArgumentException{
    public LottoApplicationException(String message) {
        super("[ERROR] " + message);
    }
}
